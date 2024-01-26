import java.time.LocalDateTime; // For get Local Date Time
import java.time.format.DateTimeFormatter; // For beautiful formatting the Date
public class Transaction {
    private static int transactionCnt = 1;
    private int transactionId;
    private LocalDateTime timestamp;
    private String action;
    private Book item;

    public Transaction(String action, Book item) {
        this.transactionId = transactionCnt++; // I used your idea, to just increase the Counter
        this.timestamp = LocalDateTime.now();
        this.action = action;
        this.item = item;
    }

    public void displayTransactionInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Timestamp: " + timestamp.format(formatter));
        System.out.println("Action: " + action);
        System.out.println("Item Info:");
        item.displayBookInfo();
        System.out.println();
    }
}