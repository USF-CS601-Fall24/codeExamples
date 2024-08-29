package interfaces.comparator.bookExample;

public class Book {
    private String title;
    private double rating;

    public Book(String title, double rating) {

        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
