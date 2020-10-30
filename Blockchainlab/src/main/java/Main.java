import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Blockchain blockchain = null;
        if (new File("src/main/currentState/blockchain.json").exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                blockchain = objectMapper.readValue(new File("src/main/currentState/blockchain.json"), Blockchain.class);
            } catch (JsonProcessingException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            blockchain = new Blockchain();
            blockchain.registerNewTransaction(new Transaction(2.5, "Jacek", "Agatka"));
            blockchain.registerNewTransaction(new Transaction(4.5, "Agatka", "Jonasz"));
            blockchain.registerNewTransaction(new Transaction(5.5, "Jonasz", "Jacek"));
            blockchain.acceptCurrentState();
            blockchain.registerNewTransaction(new Transaction(1.25, "Jacek", "Jonasz"));
            blockchain.registerNewTransaction(new Transaction(3.25, "Jonasz", "Jacek"));
            blockchain.acceptCurrentState();
            blockchain.registerNewTransaction(new Transaction(1.8, "Agatka", "Jonasz"));
            blockchain.registerNewTransaction(new Transaction(1.4, "Agatka", "Jacek"));
            blockchain.registerNewTransaction(new Transaction(1.2, "Jacek", "Jonasz"));
            blockchain.registerNewTransaction(new Transaction(2.2, "Jacek", "Agatka"));
            blockchain.acceptCurrentState();
        }


        if (blockchain != null) {
            //TODO add transactions here
            blockchain.registerNewTransaction(new Transaction(40.4, "Adam", "Juliusz"));
            blockchain.acceptCurrentState();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writeValue(new File("src/main/currentState/blockchain.json"), blockchain);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
