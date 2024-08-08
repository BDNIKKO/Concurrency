package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> buffer;
    private final int maxSize;

    public SharedBuffer(int maxSize) {
        this.buffer = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void add(int value) throws InterruptedException {
        while (buffer.size() == maxSize) {
            wait();
        }
        buffer.add(value);
        notifyAll();
    }

    public synchronized int remove() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        int value = buffer.remove();
        notifyAll();
        return value;
    }
}
