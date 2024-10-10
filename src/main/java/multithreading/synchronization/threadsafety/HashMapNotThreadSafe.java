package multithreading.synchronization.threadsafety;

import java.util.HashMap;

// Not thread-safe, concurrent writes may leave the map in an inconsistent state
public class HashMapNotThreadSafe {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("Hao", 1);
        map.put("Tanisha", 2);

        // Access concurrently
        Thread t1 = new Thread(() -> {
            map.put("Katherine", 3);
            System.out.println("Thread 1 added Katherine");
        });

        Thread t2 = new Thread(() -> {
            map.put("Tanisha", 4);
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

        // Potentially inconsistent state
        System.out.println("Final map: " + map);
    }
}