package multithreading.waitNotify.fooddelivery.efficient;

public class Food {
    private String name;
    private boolean isFoodDelivered = false;

    public Food(String name) {
        this.name = name;
    }

    public void eat() throws InterruptedException {
            synchronized(this){
                System.out.println(Thread.currentThread().getName() + " got the lock for the synchronized block");

                while (!isFoodDelivered){
                    System.out.println("Waiting for delivery.... Released the lock");
                    this.wait();
                    System.out.println(Thread.currentThread().getName() + " got notified and got the lock");
                }
            }
            System.out.println(Thread.currentThread().getName() + "Released the lock. Eating now...");
    }

    public void deliver(){
        synchronized(this){
            System.out.println(Thread.currentThread().getName() + " got the lock for the synchronized block");
            this.isFoodDelivered = true;
            System.out.println("Food delivered");
            //this.notify();
            this.notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " released the lock");
    }
}

