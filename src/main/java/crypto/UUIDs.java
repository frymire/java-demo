package crypto;

import java.util.UUID;

public class UUIDs {

  public static void main(String[] args) {

    // NOTE: Using random crypto.UUIDs is potentially a security problem,
    // since it uses the machine's MAC address and timestamp of creation.

    UUID u1 = UUID.randomUUID();
    UUID u2 = UUID.randomUUID();
    UUID u3 = u1;
    UUID u4 = UUID.fromString(u1.toString());

    System.out.println("UUID 1: " + u1);
    System.out.println("UUID 2: " + u2);
    System.out.println("UUID 3: " + u3);
    System.out.println("UUID 4: " + u4);

    System.out.println(u1.equals(u2)); // false		
    System.out.println(u1.equals(u3)); // true

    System.out.println(u1 == u3); // true, but misleading.  Don't use == to compare crypto.UUIDs
    System.out.println(u1 == u4); // false, even though the bits match. Don't use == to compare crypto.UUIDs
    System.out.println(u1.equals(u4)); // true		
  }
}
