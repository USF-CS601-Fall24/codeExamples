package catalog;

public class Driver {
    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();
        libraryCatalog.addBook("The Da Vinci Code", "Dan Brown");
        libraryCatalog.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        libraryCatalog.addBook("1984", "George Orwell");
        UserInterface ui = new UserInterface(libraryCatalog);
        ui.interact();
    }
}
