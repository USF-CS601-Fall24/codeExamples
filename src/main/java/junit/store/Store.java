package junit.store;

public class Store {
    public static void main(String[] args) {
        // See the test/java folder and fill in code in the tests

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Apple juice", 3.99));
        cart.addProduct(new Product("Milk", 4.65));
        cart.addProduct(new Product("Potatoes", 2.99));
        cart.addProduct(new Product("Cauliflower", 3.59));
        System.out.println(cart.calculateTotal());
        System.out.println(cart);
    }
}
