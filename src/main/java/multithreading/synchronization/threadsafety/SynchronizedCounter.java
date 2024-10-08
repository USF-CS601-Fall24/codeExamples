package multithreading.synchronization.threadsafety;

public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
        System.out.println(c);
    }

    public void incrementWithSynchronizedBlock() {
        synchronized (this) {
            c++;
            System.out.println(c);
        }
    }


    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

}
