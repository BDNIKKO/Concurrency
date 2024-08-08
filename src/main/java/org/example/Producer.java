package org.example;

import java.util.Random;

public class Producer implements Runnable {
    private final SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                int value = random.nextInt(100);
                sharedBuffer.add(value);
                System.out.println("Produced: " + value);
                // Removed Thread.sleep()
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
