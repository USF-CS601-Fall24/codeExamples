package interfaces.iterableAndIterator;

import java.util.Arrays;
import java.util.Iterator;

public class ToyBox implements Iterable<String> {
    private String[] toys;
    private int size;

    public ToyBox() {
        this.toys = new String[10];
        this.size = 0;
    }
    public ToyBox(String[] newToys) {
        this.toys = newToys;
        this.size = toys.length;
    }
    public void add(String toy) {
        toys[size] = toy;
        size++;

    }

    public Iterator<String> iterator() {
        Iterator<String> it = new ToyIterator();
        return it;
    }

    class ToyIterator implements Iterator<String> {
        private int currentIndex = 0;

        public boolean hasNext() {
            boolean b = currentIndex < size && (toys[currentIndex] != null);
            //System.out.println(currentIndex + " " + b);
            return b;
        }
        public String next() {
            String nextElem = toys[currentIndex];
            currentIndex++;
            return nextElem;
        }

    }// inner class MyIterator

}

