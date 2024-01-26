import java.io.Serializable; // import Interface Serializable
public class Book implements Serializable { // Implements - реализует which means the class can be Serializable
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + this.title + ", Author: " + this.author + ", ISBN: " + this.isbn);
    }
}
