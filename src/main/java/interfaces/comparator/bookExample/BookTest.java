package interfaces.comparator.bookExample;

import java.util.TreeSet;

public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Book("A", 3.5);
        Book b2 = new Book("B", 3.2);
        BookComparatorByTitle compTitle = new BookComparatorByTitle();
        BookComparatorByRating compRating = new BookComparatorByRating();

        TreeSet<Book> bookSet1 = new TreeSet<>(compTitle);
        TreeSet<Book> bookSet2 = new TreeSet<>(compRating);
        bookSet1.add(b1);
        bookSet1.add(b2);
        bookSet2.add(b1);
        bookSet2.add(b2);
        System.out.println(bookSet1);
        System.out.println();
        System.out.println(bookSet2);


    }
}
