package multithreading.synchronization.barriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        ExecutorService poolManager = Executors.newFixedThreadPool(NUM_THREADS);
        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            System.out.println("All threads have reached the barrier."); // this is the function that will be invoked when all threads reached the barrier
        });

        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            poolManager.submit(() -> {
                System.out.println("Thread " + threadId + " started work.");
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    barrier.await(); // Wait for other tasks to finish
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println(e);
                }
                //System.out.println("Thread " + threadId + " has crossed the barrier.");

            });

        }
    }
}
