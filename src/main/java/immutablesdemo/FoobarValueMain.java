package immutablesdemo;

import java.util.List;
import immutablesdemo.ImmutableFoobarValue5;

public class FoobarValueMain {
  public static void main(String... args) {

    ImmutableFoobarValue5 value = ImmutableFoobarValue5.builder()
            .foo(2)
            .bar("Bar")
            .addBuz(1, 3, 4)
            .build(); // crux=[]

    System.out.println(value); // FoobarValue{foo=2, bar=Bar, buz=[1, 3, 4], crux=[]}
    System.out.println(value.foo()); // 2
    List<Integer> buz = value.buz();
    System.out.println(buz); // [1, 3, 4]
    System.out.println(buz.get(1)); // 3
  }
}
