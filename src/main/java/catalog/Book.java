package catalog;

/** A class representing a book */
public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", isAvailable? " + !isCheckedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /** If the book is available (not checked out), then
     *  set isCheckout to true and return true,
     *  otherwise return false
     * @return true if we could check out the book, and false otherwise
     */
    public boolean checkout() {
        if (isCheckedOut)
            return false; // cannot check it out, since it is not available
        // book is available
        isCheckedOut = true;
        return true;
    }

    /**
     * If the book is checked out, return it by setting isCheckedOut to false
     * and return true;
     * Otherwise, return false, because the book could not be returned
     * @return true if the book could be returned, and false otherwise
     */
    public boolean returnToLibrary() {
        if (!isCheckedOut)
            return false; // cannot return if it was not checked out
        // book was checked out, but is now returned:
        isCheckedOut = false;
        return true;
    }
}
