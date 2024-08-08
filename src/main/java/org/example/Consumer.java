package org.example;

public class Consumer implements Runnable {
    private final SharedBuffer sharedBuffer;
    private int sum;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
        this.sum = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = sharedBuffer.remove();
                sum += value;
                System.out.println("Consumed: " + value + " | Sum: " + sum);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
