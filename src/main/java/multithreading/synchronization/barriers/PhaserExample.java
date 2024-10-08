package multithreading.synchronization.barriers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample {
    public static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Phaser phaser = new Phaser();

        for (int i = 0; i < NUM_THREADS; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                phaser.register();
                try {
                    System.out.println("Task " + taskId + " is starting.");
                    Thread.sleep((long) (Math.random() * 1000)); // Random work duration
                    System.out.println("Task " + taskId + " is complete.");
                } catch (InterruptedException e) {
                    System.out.println(e);
                } finally {
                    phaser.arriveAndDeregister();
                }
            });
        }

        executorService.shutdown();
        // Main thread waits for all to complete the current phase (0).
        phaser.awaitAdvance(phaser.getPhase()); // this will be phase 0

        System.out.println("All tasks have completed their work. Main thread can proceed.");
    }
}
