import java.util.ArrayList; // For contain a array of objects (classes)
import java.util.List;

public class Library {
    public List<Book> books;
    public List<EBook> ebooks;
    public List<Book> checkedOutBooks;
    public List<EBook> checkedOutEBooks;
    public List<Transaction> transactions;

    public Library() { // Just simple constructor with empty lists
        this.books = new ArrayList<>();
        this.ebooks = new ArrayList<>();
        this.checkedOutBooks = new ArrayList<>();
        this.checkedOutEBooks = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void displayAllBooks() {
        for (Book book
                : books) {
            book.displayBookInfo();
        }
    }

    public void displayAllEBooks() {
        for (EBook ebook
                : ebooks) {
            ebook.displayBookInfo();
        }
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void addEBook(EBook ebook) {
        ebooks.add(ebook);
    }

    public void checkOutBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            checkedOutBooks.add(book);
            System.out.println("Successfully heck out book");
            transactions.add(new Transaction("Check Out", book));
        } else {
            System.out.println("Book not available in the library.");
        }
    }

    public void checkOutEBook(EBook ebook) {
        if (ebooks.contains(ebook)) {
            ebooks.remove(ebook);
            checkedOutEBooks.add(ebook);
            System.out.println("Successfully heck out ebook");
            transactions.add(new Transaction("Check Out", ebook));
        } else {
            System.out.println("EBook not available in the library.");
        }
    }

    public void displayCheckedOutItems() {
        System.out.println("Checked-Out Books:");
        for (Book book:
             checkedOutBooks) {
            book.displayBookInfo();
        }

        System.out.println("\nChecked-Out EBooks:");
        for (EBook ebook:
                checkedOutEBooks) {
            ebook.displayBookInfo();
        }
    }
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction
                : transactions) {
            transaction.displayTransactionInfo();
        }
    }

}
