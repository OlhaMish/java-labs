package com.olechok.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularBufferTest {

    @Test
    void testPutAndTake() throws InterruptedException {
        CircularBuffer<String> buffer = new CircularBuffer<>(2);

        buffer.put("Item 1");
        assertFalse(buffer.isEmpty(), "Buffer should not be empty after putting an item.");

        buffer.put("Item 2");
        assertEquals("Item 1", buffer.take(), "First item should be 'Item 1'");
        assertFalse(buffer.isEmpty(), "Buffer should not be empty after taking one item.");

        buffer.put("Item 3");
        assertEquals("Item 2", buffer.take(), "Second item should be 'Item 2'");
        assertEquals("Item 3", buffer.take(), "Third item should be 'Item 3'");
        assertTrue(buffer.isEmpty(), "Buffer should be empty after taking all items.");
    }

    @Test
    void testIsEmpty() throws InterruptedException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);
        assertTrue(buffer.isEmpty(), "Buffer should be empty upon initialization.");

        buffer.put(1);
        assertFalse(buffer.isEmpty(), "Buffer should not be empty after putting an item.");
    }

    @Test
    void testBufferOvercapacity() throws InterruptedException {
        CircularBuffer<String> buffer = new CircularBuffer<>(2);

        buffer.put("Item 1");
        buffer.put("Item 2");

        Thread consumer = new Thread(() -> {
            try {
                assertEquals("Item 1", buffer.take(), "Should take Item 1");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();

        buffer.put("Item 3"); // This should not block because space is available after consuming Item 1.

        consumer.join();
        assertFalse(buffer.isEmpty(), "Buffer should not be empty after consuming one item.");
    }

    @Test
    void testWaitOnEmptyBuffer() throws InterruptedException {
        CircularBuffer<String> buffer = new CircularBuffer<>(2);

        Thread consumer = new Thread(() -> {
            try {
                String message = buffer.take();
                assertNotNull(message, "Consumer should successfully take an item.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();

        Thread.sleep(100); // Let consumer wait for an item.

        buffer.put("Item 1");
        consumer.join();
    }

    @Test
    void testBufferOverflow() throws InterruptedException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.put(1);
        buffer.put(2);

        Thread producer = new Thread(() -> {
            try {
                buffer.put(3); // This should block until space is available.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();

        Thread.sleep(100); // Let the producer thread start and wait for space.

        assertDoesNotThrow(() -> buffer.take(), "Taking an item should allow producer to proceed.");

        producer.join();
    }
}
