package multithreading.basic;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Run this task in a separate thread
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Woke up from sleep");
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted: " + e);
            }
            String result = "I completed work";
            System.out.println("Returning: " + result);
            return result;
        });

        // Set the function that will be executed when the result is ready
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });

        System.out.println("Reached this line in main");
        future.join();
    }
}
