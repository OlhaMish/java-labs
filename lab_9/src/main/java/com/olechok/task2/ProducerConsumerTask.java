package com.olechok.task2;

import java.util.concurrent.atomic.AtomicInteger;


public class ProducerConsumerTask {
    public static void main(String[] args) {
        CircularBuffer<String> buffer1 = new CircularBuffer<>(10);
        CircularBuffer<String> buffer2 = new CircularBuffer<>(10);

        AtomicInteger messageCounter = new AtomicInteger(1);

        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            Thread producer = new Thread(() -> {
                try {
                    while (true) {
                        String message = "Потік № " + threadId + " згенерував повідомлення " + messageCounter.getAndIncrement();
                        buffer1.put(message);
                        System.out.println(message);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            producer.setDaemon(true);
            producer.start();
        }

        for (int i = 1; i <= 2; i++) {
            final int threadId = i;
            Thread translator = new Thread(() -> {
                try {
                    while (true) {
                        String message = buffer1.take();
                        String translatedMessage = "Потік № " + threadId + " переклав повідомлення " + message;
                        buffer2.put(translatedMessage);
                        System.out.println(translatedMessage);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            translator.setDaemon(true);
            translator.start();
        }

        Thread mainThread = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    String message = buffer2.take();
                    System.out.println("Основний потік вичитав: " + message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        mainThread.start();

        try {
            mainThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Програма завершена.");
    }
}
