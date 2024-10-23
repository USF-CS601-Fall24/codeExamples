package multithreading.synchronization.threadsafety;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedDataWithReentrantLock {
    private final List<Integer> data = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public List<Integer> readData() {
        lock.readLock().lock();
        try {
            return readNested(); // calling a method that also needs the read lock
        } finally {
            lock.readLock().unlock();
        }
    }

    private List<Integer> readNested() {
        lock.readLock().lock();  // since we are using the reentrant lock, it will be able to get another read lock
        try {
            return new ArrayList<>(data);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(int value) {
        lock.writeLock().lock(); //
        try {
            // do some work ...
            writeInNested(value); // calling a method that also requires a write lock
            // do more work...
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void writeInNested(int value) {
        lock.writeLock().lock(); // since we are using the reentrant lock, it will be able to get another write lock, while holding the first write lock it got in writeData
        try {
            data.add(value);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
