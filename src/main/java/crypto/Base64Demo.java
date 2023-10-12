package crypto;

import java.nio.ByteBuffer;
import java.util.Base64;

public class Base64Demo {

  public static void main(String[] args) {

    int original = 123456789;

    // Convert int to Base64
    String encoded = intToBase64(original);
    System.out.println("Encoded int: " + encoded);

    // Convert Base64 back to int
    int decoded = base64ToInt(encoded);
    System.out.println("Decoded value: " + decoded);
  }

  public static String intToBase64(int value) {
    byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
    return Base64.getEncoder().encodeToString(bytes);
  }

  public static int base64ToInt(String base64) {
    byte[] bytes = Base64.getDecoder().decode(base64);
    return ByteBuffer.wrap(bytes).getInt();
  }
}
