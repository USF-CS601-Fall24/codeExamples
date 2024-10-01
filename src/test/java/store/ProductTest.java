package store;

import junit.store.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProductConstructor() {
            Product p = new Product("apple", 1);
            assertEquals(p.getName(), "apple");
            assertEquals(p.getPrice(), 1, 0.001);

    }

    @Test
    public void testGetName() {
        Product product = new Product("Milk", 4.65);
        String name = product.getName();
        assertEquals("Milk", name, "Wrong name of the product");
    }

    @Test
    public void testGetPrice() {
        Product product = new Product("Milk", 4.65);
        double price = product.getPrice();
        assertEquals(4.65, price, 0.001);
    }
}
