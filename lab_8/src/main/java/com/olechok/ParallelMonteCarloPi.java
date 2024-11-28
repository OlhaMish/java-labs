package com.olechok;

import java.util.concurrent.ThreadLocalRandom;

public class ParallelMonteCarloPi implements Runnable {
    private final long iterationsPerThread;
    private final long[] pointsInsideCircle;
    private final int threadIndex;

    public ParallelMonteCarloPi(long iterationsPerThread, long[] insideCircleCounts, int threadIndex) {
        this.iterationsPerThread = iterationsPerThread;
        this.pointsInsideCircle = insideCircleCounts;
        this.threadIndex = threadIndex;
    }

    @Override
    public void run() {
        long count = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (long j = 0; j < iterationsPerThread; j++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1) {
                count++;
            }
        }
        pointsInsideCircle[threadIndex] = count;
    }
}
