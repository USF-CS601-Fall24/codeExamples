package store;

import junit.store.Product;
import junit.store.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("Orange juice", 3.99);
        product2 = new Product("Milk", 4.65);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1);
        assertEquals(1, cart.getNumProducts());
        assertTrue(cart.getProducts().contains(product1));
    }

    @Test
    public void testAddNullProductThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cart.addProduct(null));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(product1);
        cart.removeProduct(product1);
        assertEquals(0, cart.getNumProducts());
        assertFalse(cart.getProducts().contains(product1));
    }

    @Test
    public void testRemoveNullProductThrowsIllegalArgumentException() {
       assertThrows(IllegalArgumentException.class, () -> cart.removeProduct(null));
    }

    @Test
    public void testCalculateTotal() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals(8.64, cart.calculateTotal(), 0.01);
    }

    @Test
    public void testToString() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals("ShoppingCart{[Product{name='Orange juice', price=3.99}, Product{name='Milk', price=4.65}]}", cart.toString());

    }
}
