package interfaces.iterableAndIterator;

import java.util.Iterator;

public class ToyBoxMain {
    public static void main(String[] args) {
        ToyBox box = new ToyBox();
        box.add("bear");
        box.add("car");
        box.add("lego");
        box.add("puzzle");

        // Iterate over the toys using iterator explicitly
        Iterator<String> it = box.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("");

        // Another way to iterate over the toys:
        // Uses iterator implicitly
        for (String toy: box) {
            System.out.println(toy);
        }
    }
}
