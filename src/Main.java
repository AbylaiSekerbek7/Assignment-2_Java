import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // at First load the data from library_data.txt
        DataStorage.loadData(library.books, library.ebooks);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add E-Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Display All EBooks");
            System.out.println("5. Check Out Book");
            System.out.println("6. Check Out E-Book");
            System.out.println("7. Display Checked-Out Items");
            System.out.println("8. Display Transaction History");
            System.out.println("9. Save All Books");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;

                case 2:
                    System.out.print("Enter ebook title: ");
                    String ebookTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String ebookAuthor = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ebookISBN = scanner.nextLine();
                    System.out.print("Enter file size (in MB): ");
                    double fileSize = scanner.nextDouble();
                    library.addEBook(new EBook(ebookTitle, ebookAuthor, ebookISBN, fileSize));
                    break;

                case 3:
                    System.out.print("All Books: \n");
                    library.displayAllBooks();
                    break;

                case 4:
                    System.out.print("All EBooks: \n");
                    library.displayAllEBooks();
                    break;

                case 5:
                    if (!library.books.isEmpty()) {
                        System.out.print("Enter the index of the book to check out: ");
                        int bookIndex = scanner.nextInt();
                        library.checkOutBook(library.books.get(bookIndex));
                    } else {
                        System.out.println("No books available.");
                    }
                    break;

                case 6:
                    if (!library.ebooks.isEmpty()) {
                        System.out.print("Enter the index of the ebook to check out: ");
                        int ebookIndex = scanner.nextInt();
                        library.checkOutEBook(library.ebooks.get(ebookIndex));
                    } else {
                        System.out.println("No ebooks available.");
                    }
                    break;

                case 7:
                    library.displayCheckedOutItems();
                    break;

                case 8:
                    library.displayTransactionHistory();
                    break;

                case 9:
                    DataStorage.saveData(library.books, library.ebooks);
                    break;

                case 0:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Enter correct choice, Please try again.");
            }
        }
    }
}
