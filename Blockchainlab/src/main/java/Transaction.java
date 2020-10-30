import java.io.Serializable;

public class Transaction implements Serializable {
    private double amount;
    private String sender;
    private String receiver;

    public Transaction(double amount, String sender, String receiver) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Transaction() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
