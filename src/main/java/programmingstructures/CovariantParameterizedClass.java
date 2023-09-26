package programmingstructures;

public class CovariantParameterizedClass<T extends CovariantParameterizedClass.DoesIt> {

  T m_prototype;

  // You wish you could do this, but T is unavailable due to type erasure.
  //public ParameterizedClass() { m_prototype = new T(); } // error

  // Instead, pass a prototype instance of the type you want to the constructor.
  public CovariantParameterizedClass(T prototype) { m_prototype = prototype; }

  public void doIt() { m_prototype.doIt(); }

  interface DoesIt { void doIt(); }

  static class DoesItWithDoubles implements DoesIt {
    Double value;
    public DoesItWithDoubles(Double value) { this.value = value; }
    public void doIt() { System.out.println(value); }
  }

  static class DoesItWithIntegers implements DoesIt {
    Integer value;
    public DoesItWithIntegers(Integer value) { this.value = value; }
    public void doIt() { System.out.println(value); }
  }

  public static void main(String[] args) {

    // Make an instance of ClassWithPrototype using a Double as the prototype
    final CovariantParameterizedClass<DoesItWithDoubles> demo1 =
            new CovariantParameterizedClass<>(new DoesItWithDoubles(5.0));
    demo1.doIt();

    final CovariantParameterizedClass<DoesItWithIntegers> demo2 =
            new CovariantParameterizedClass<>(new DoesItWithIntegers(5));
    demo2.doIt();
  }
}
