package programmingstructures;

import java.util.ArrayList;
import java.util.List;

public class Contravariance {

  static class Fruit {
    private final String color;
    public Fruit(String color) { this.color = color; }
    public String getColor() { return color; }
    @Override public String toString() { return "I'm a " + color + " Fruit."; }
  }
  static class Apple extends Fruit {
    public Apple(String color) { super(color); }
    @Override public String toString() { return "I'm a " + getColor() + " Apple."; }
  }
  static class GrannySmith extends Apple {
    public GrannySmith() { super("green"); }
    @Override public String toString() { return "I'm a GrannySmith. Of course, I'm " + getColor() + "."; }
  }

  public static void main(String[] args) {

    List<? super Apple> apples = new ArrayList<>();
//    apples.add(new Fruit()); // compile error, Fruit doesn't satisfy the bound
    apples.add(new Apple("red"));
    apples.add(new GrannySmith());

    // Obviously, you can't try to get a fruit from this list, since it doesn't satisfy the bound.
//    Fruit fruit = apples.get(0); // compile error

    // Even so, type erasure prevents us from directly getting Apple instances from this data structure.
    // Contravariance (? super ...) lets you add, covariance (? extends ...) lets you retrieve.
//    Apple apple = apples.get(0); // compile error

    // Trivially, you can retrieve instances of Object, since everything inherits from it.
    Object object = apples.get(1); // OK, but not type-specific
    System.out.println(object); // works because toString() is a method on Object

    // If you want to retrieve Apples specifically, you have to cast.
    Apple apple = (Apple) apples.get(0);
    System.out.println("Apple #0 is " + apple.getColor() + "."); // getColor() is not available on Object, need to cast

    // You can cast to something more specific than apples, but it's risky.
    GrannySmith grannySmith = (GrannySmith) apples.get(1); // ok
    System.out.println(grannySmith);
//    GrannySmith notGrannySmith = (GrannySmith) apples.get(0); // run-time ClassCastException
//    System.out.println(notGrannySmith);
  }
}
