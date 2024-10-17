package multithreading.synchronization.threadsafety;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeMapWithAdvancedLock {
    private Map<String, String> englishToSpanishMap;
    private ReentrantReadWriteLock lock;

    public ThreadSafeMapWithAdvancedLock() {
        englishToSpanishMap = new HashMap<>();
        lock = new ReentrantReadWriteLock();
    }

    public String getSpanishWord(String englishWord) {
        try {
            lock.readLock().lock();
            return englishToSpanishMap.get(englishWord);
        }
        finally {
            lock.readLock().unlock();
        }
    }

    public void addWord(String englishWord, String spanishWord) {
        try {
            lock.writeLock().lock();
            englishToSpanishMap.put(englishWord, spanishWord);
        }
        finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public String toString() {
        try {
            lock.readLock().lock();
            return englishToSpanishMap.toString();
        }
        finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ThreadSafeMapWithAdvancedLock tsMap = new ThreadSafeMapWithAdvancedLock();
        Thread t1 = new Thread(() -> {
            tsMap.addWord("one", "uno");
            tsMap.addWord("two", "dos");

        });
        Thread t2 = new Thread(() -> {
            tsMap.addWord("three", "tres");

        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println(tsMap);
        }
        catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}
