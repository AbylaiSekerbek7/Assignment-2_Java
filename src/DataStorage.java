import java.io.*; // Importing all classes and interfaces
import java.util.List;
public class DataStorage {
    private static final String FileName = "library_data.txt"; // final means that we can't change it like (const)

    public static void saveData(List<Book> books, List<EBook> ebooks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FileName))) {
            oos.writeObject(books); // Saving books
            oos.writeObject(ebooks); // Savind ebooks
            System.out.println("Data saved successfully.");
        } catch (IOException e) { // If we catch a exception
            e.printStackTrace(); // Just printing the Errors
            System.out.println("Error saving data.");
        }
    }

    @SuppressWarnings("unchecked") // Actually i don't know on 100% what is it seems like we just say to compiler ignore any Errors
    public static void loadData(List<Book> books, List<EBook> ebooks) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FileName))) {
            List<Book> savedBooks = (List<Book>) ois.readObject(); // Converting the data to List<Book>
            List<EBook> savedEBooks = (List<EBook>) ois.readObject(); // Converting the data to List<EBook>

            books.clear(); // At first clear books
            books.addAll(savedBooks); // And then adding books

            ebooks.clear(); // At first clear ebooks
            ebooks.addAll(savedEBooks); // And then adding books

            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) { // Catching the exception
            System.out.println("Error loading data. Starting with an empty library.");
        }
    }
}
