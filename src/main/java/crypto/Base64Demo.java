package crypto;

import java.nio.ByteBuffer;
import java.util.Base64;

public class Base64Demo {

  public static void main(String[] args) {

    int originalInt = 123456789;
    String encodedInt = intToBase64(originalInt);
    System.out.println("Encoded int: " + encodedInt);
    int decodedInt = base64ToInt(encodedInt);
    System.out.println("Decoded value: " + decodedInt);

    String originalString = "Hello";
    String encodedString = stringToBase64(originalString);
    System.out.println("Encoded string: " + encodedString);
    String decodedString = base64ToString(encodedString);
    System.out.println("Decoded string: " + decodedString);
  }

  public static String intToBase64(int value) {
    byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
    return Base64.getEncoder().encodeToString(bytes);
  }

  public static int base64ToInt(String base64) {
    byte[] bytes = Base64.getDecoder().decode(base64);
    return ByteBuffer.wrap(bytes).getInt();
  }

  public static String stringToBase64(String value) {
    return Base64.getEncoder().encodeToString(value.getBytes());
  }

  public static String base64ToString(String base64) {
    byte[] bytes = Base64.getDecoder().decode(base64);
    return new String(bytes);
  }
}
