package catalog;

import java.util.Scanner;

public class UserInterface {
    private LibraryCatalog catalog;

    public UserInterface(LibraryCatalog catalog) {
        this.catalog = catalog;
    }

    /**
     * Interact with the user via a command line interface, and allow a user to check out and return books.
     * Assume we have only one copy of each book in the library.
     */
    public void interact() {
        // Allow the user to see all available books, checkout a book or return a book
        Scanner sc = new Scanner(System.in);
        String userResponse = " ";
        while (!userResponse.equals("4")) {
            System.out.println("1. Check out a book");
            System.out.println("2. Return a book");
            System.out.println("3. Print the list of available books");
            System.out.println("4. Exit the program");
            String userInput = sc.nextLine();
            String title  = "";
            switch (userInput) {
                case "1":
                    System.out.println("You would like check out a book. Please enter the title: ");
                    title = sc.nextLine();
                    if (title != null && catalog.checkoutBook(title)) {
                            System.out.println("Successfully checked out.");
                    }
                    else {
                        System.out.println("Could not check out the book");
                    }
                    break;

                case "2":
                    System.out.println("You would like to return a book. Please enter the title: ");
                    title = sc.nextLine();
                    if (title != null && catalog.returnBook(title)) {
                        System.out.println("Successfully checked out.");
                    }
                    else {
                        System.out.println("Could not check out the book");
                    }
                    break;

                case "3":
                    System.out.println("Show available books");
                    catalog.printAvailableBooks();
                    break;

                case "4":
                    System.out.println("Exit the program");
                    return;
                default:
                    System.out.println("You did not enter 1-4. Try again. ");
            }
        }

    }
}
