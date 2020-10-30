import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Blockchain implements Serializable {
    private List<Block> blocks;
    private Block head;

    public Blockchain() {
        this.blocks = new LinkedList<Block>();
        this.head = new Block(null);
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Block getHead() {
        return head;
    }

    public void setHead(Block head) {
        this.head = head;
    }

    public void registerNewTransaction(Transaction transaction) {
        this.head.addTransaction(transaction);
    }

    public void acceptCurrentState() {
        String currentBlockID = Sha256.getSha256hash(this.head.toString());
        this.head.setHash(currentBlockID);
        this.blocks.add(head);
        this.head = new Block(currentBlockID);
    }
}
