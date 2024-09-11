package inheritance.inappropriateUseOfInheritance;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// In this case, using the composition would be better
public class InstrumentedHashSetWithComposition<E>  {
    // The number of attempted element insertions
    private int addCount = 0;
    private HashSet<E> set = new HashSet<>();

    public InstrumentedHashSetWithComposition() {}

    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c); // addAll method in the HashSet class will call the add method
        // from HashSet, but not the add method in this class.
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSetWithComposition<String> s = new InstrumentedHashSetWithComposition<>();
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }

}
