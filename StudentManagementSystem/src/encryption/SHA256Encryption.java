package encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Encryption {
  public static String encrypt(String input) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      byte[] hash = messageDigest.digest(input.getBytes());

      StringBuilder hexString = new StringBuilder();
      for (byte b : hash) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) hexString.append('0');
        hexString.append(hex);
      }

      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    String input = "antenglish@123";
    String encrypted = encrypt(input);
    System.out.println("Encrypted string: " + encrypted);
  }
}
