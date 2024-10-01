package junit.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// See the test/java folder - your goal is to write JUnit tests for this class
public class ShoppingCart implements Iterable<Product> {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null)
            throw new IllegalArgumentException();
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (product == null)
            throw new IllegalArgumentException();
        products.remove(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public int getNumProducts() {
        return products.size();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + products +
                '}';
    }
}
