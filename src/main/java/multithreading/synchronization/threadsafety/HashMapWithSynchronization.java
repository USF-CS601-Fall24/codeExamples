package multithreading.synchronization.threadsafety;

import java.util.HashMap;

// In this implementation, we made HashMapWithSynchronization class thread-safe. Does not matter how someone will use it, its state will be consistent
public class HashMapWithSynchronization {
    private HashMap<String, Integer> map = new HashMap<>();

    public synchronized void put(String key, Integer value) {
        map.put(key, value);
    }

    public synchronized Integer get(String key) {
        return map.get(key);
    }

    @Override
    public synchronized String toString() {
        return map.toString();
    }

    public static void main(String[] args) {
        HashMapWithSynchronization hashMapWithSynchronization = new HashMapWithSynchronization();

        hashMapWithSynchronization.put("Hao", 1);
        hashMapWithSynchronization.put("Tanisha", 2);

        // Access concurrently
        Thread t1 = new Thread(() -> {
            hashMapWithSynchronization.put("Katherine", 3);
            System.out.println("Thread 1 added Katherine");
        });

        Thread t2 = new Thread(() -> {
            hashMapWithSynchronization.put("Tanisha", 4);
            System.out.println("Thread 2 modified Tanisha's value");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

       // Will be in a consistent state
        System.out.println("Final map: " + hashMapWithSynchronization);
    }


}
