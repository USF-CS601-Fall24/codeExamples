package multithreading.waitNotify.fooddelivery.efficient;

public class FoodDeliveryDriver {
    public static void main(String[] args) {
        Food food = new Food("Pasta Marinara");
        Thread customer = new Thread (new FoodDelivery.Customer(food), "customer1");
        Thread anotherCustomer = new Thread (new FoodDelivery.Customer(food), "customer2");

        Thread deliveryGuy = new Thread (new FoodDelivery.DeliveryGuy(food), "delivery guy");
        customer.start();
        anotherCustomer.start();
        deliveryGuy.start();
    }
}
