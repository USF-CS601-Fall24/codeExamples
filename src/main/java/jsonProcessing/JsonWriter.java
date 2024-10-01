package jsonProcessing;

import catalog.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/** Demonstrates how to write to a json file */
public class JsonWriter {

    /**
     * Demonstrates how to convert an object to a  json string using toJson method
     * @param book
     * @return json string representing the book object
     */
    public String serializeBookUsingToJson(Book book) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonInString  = gson.toJson(book);
        return jsonInString;
    }

    /**
     * Convert a Book object to a JsonObject using addProperty()
     * @param book
     * @return JsonObject representing a book
     */
    public JsonObject serializeBook(Book book) {
        JsonObject bookObj = new JsonObject();
        bookObj.addProperty("title", book.getTitle());
        bookObj.addProperty("author", book.getAuthor());
        bookObj.addProperty("checkedOut", book.isCheckedOut());
        return bookObj;
    }


    /**
     * Convert a list of books to a JsonObject
     * @param books list of books
     * @return JsonObject storing a json array of books as the value for "books"
     */
    public JsonObject serializeBookList(List<Book> books) {
        JsonObject obj = new JsonObject();
        JsonArray jsonArr = new JsonArray();
        for (Book book: books) {
            JsonObject bookObj = serializeBook(book);
            jsonArr.add(bookObj);
        }
        obj.add("books", jsonArr);
        return obj;
    }

    /**
     * Write a json object to the file
     * @param obj json object
     * @param jsonFilePath name of the output file
     */
    public void writeToFile(JsonObject obj, String jsonFilePath) {
        try (PrintWriter pw = new PrintWriter(jsonFilePath)) {
            pw.println(obj);
            pw.flush();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        JsonWriter jsonWriter = new JsonWriter();
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("Kite Runner", "Khaled Hosseini");
        Book book2 = new Book("We'll Prescribe You a Cat", "Syou Ishida");
        books.add(book1);
        books.add(book2);
        System.out.println(jsonWriter.serializeBookUsingToJson(book1));

        jsonWriter.writeToFile(jsonWriter.serializeBookList(books),"books.json");
    }
}
