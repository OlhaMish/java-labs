package com.olechok;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of threads to use: ");
        int numThreads = scanner.nextInt();

        scanner.close();

        if (numThreads <= 0) {
            System.err.println("The number of threads must be a positive integer.");
            return;
        }

        calculatePiUsingThreads(numThreads);
    }

    private static void calculatePiUsingThreads(int numThreads) {
        final long totalIterations = 1_000_000_000L;
        final long iterationsPerThread = totalIterations / numThreads;

        long[] pointsInsideCircle = new long[numThreads];

        long startTime = System.nanoTime();

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(
                    new ParallelMonteCarloPi(iterationsPerThread, pointsInsideCircle, i)
            );
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long totalInsideCircle = 0;
        for (long count : pointsInsideCircle) {
            totalInsideCircle += count;
        }

        double piEstimate = 4.0 * totalInsideCircle / totalIterations;

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0;

        System.out.printf("PI is %.5f%n", piEstimate);
        System.out.printf("THREADS %d%n", numThreads);
        System.out.printf("ITERATIONS %,d%n", totalIterations);
        System.out.printf("TIME %.2fms%n", elapsedTime);
    }
}
