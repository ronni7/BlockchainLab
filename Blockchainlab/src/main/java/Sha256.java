import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
    public static String getSha256hash(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = messageDigest.digest(input.getBytes());
            String hashText = new BigInteger(1, bytes).toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

}
