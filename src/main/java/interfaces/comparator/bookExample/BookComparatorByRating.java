package interfaces.comparator.bookExample;

import java.util.Comparator;

public class BookComparatorByRating implements Comparator<Book> {
    public static final double RATING_THRES = 0.001;

    @Override
    public int compare(Book o1, Book o2) {
        if (Math.abs(o1.getRating() - o2.getRating()) < RATING_THRES)
            return o1.getTitle().compareTo(o2.getTitle());
            //return 0;
        else
            if (o1.getRating() < o2.getRating())
                return -1;
            else
                return 1;
        //return Double.compare(o1.getRating(), o2.getRating());
    }
}
