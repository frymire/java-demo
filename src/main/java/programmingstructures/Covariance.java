package programmingstructures;

import java.util.ArrayList;
import java.util.List;

public class Covariance {

  public static void main(String[] args) {

    // With this declaration, you can assign any list of subtype of Number.
    List<? extends Number> numbers = null;

    List<Integer> integers = new ArrayList<>();
    integers.add(0);
    integers.add(1);
    integers.add(2);
    numbers = integers;
    System.out.println(numbers.get(1));

    List<Float> floats = new ArrayList<>();
    floats.add(1.2f);
    floats.add(3.4f);
    numbers = floats;
    System.out.println(numbers.get(0));

    // However, you aren't allowed to modify the numbers list. Due to type erasure, the type
    // of the list (e.g. ArrayList<Float>, ArrayList<Integer> is unavailable at runtime, so
    // it wouldn't be able to ensure that an element of the correct type is being added.
//    numbers.add(5.6f); // compile error
  }
}
