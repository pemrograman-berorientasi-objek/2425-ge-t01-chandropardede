package fintech.model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author NIM Nama
 * @author NIM Nama
 */
public class Transaction {

     private static int nextId = 1;

    private final String pattern = "yyyy/MM/dd H:mm:ss";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private final int id;
    private final Account recipient;
    private final double amount;
    private final Date postedAt;
    private final String note;

    public Transaction(Account _recipient, double _amount, String _postedAt, String _note) throws Exception {
        this.id = getNextId();
        this.recipient = _recipient;
        this.amount = _amount;
        this.postedAt = simpleDateFormat.parse(_postedAt);
        this.note = _note;
        this.recipient.offer(this);
    }

    private static int getNextId() {
        return nextId++;
    }

    public int getId() {
        return id;
    }

    public Account getRecipient() {
        return recipient;
    }

    public double getAmount() {
        return amount;
    }

    public String getPostedAt() {
        return simpleDateFormat.format(this.postedAt);
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        // 1|wirsab|24.0|2023/02/14 14:14:14|Weekly income|24.0
        return this.id + "|" + this.recipient.getName() + "|" + this.amount + "|" + this.getPostedAt() + "|" + this.note
                + "|" + this.recipient.getBalance();
    }

}