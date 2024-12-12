package com.olechok.task2;

class CircularBuffer<T> {
    private final Object[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private final int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new Object[capacity];
    }

    public synchronized void put(T item) throws InterruptedException {
        while (size == capacity) {
            wait();
        }
        buffer[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
        notifyAll();
    }

    @SuppressWarnings("unchecked")
    public synchronized T take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        T item = (T) buffer[head];
        head = (head + 1) % capacity;
        size--;
        notifyAll();
        return item;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }
}