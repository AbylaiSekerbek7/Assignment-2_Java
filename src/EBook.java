import java.io.Serializable; // import Interface Serializable
public class EBook extends Book implements Serializable { // Implements - реализует which means the class can be Serializable
    private double fileSize; // megabytes
    public EBook(String title, String author, String isbn, double fSize) {
        super(title, author, isbn);
        this.fileSize = fSize;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("File Size: " + this.fileSize + " MB");
    }
}
