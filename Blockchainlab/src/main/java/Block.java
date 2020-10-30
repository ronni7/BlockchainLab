import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Block implements Serializable {
    private String previousHash;
    private String hash;
    private List<Transaction> transactions;

    public Block(String previousHash, String hash, List<Transaction> transactions) {
        this.previousHash = previousHash;
        this.hash = hash;
        this.transactions = transactions;
    }

    public Block(String previousHash) {
        this.transactions = new LinkedList<Transaction>();
        this.previousHash = previousHash;
    }

    public Block() {
        this.transactions = new LinkedList<Transaction>();
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
