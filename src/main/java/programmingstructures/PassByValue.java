package programmingstructures;

public class PassByValue {

  static void changeTo10(int x) {
    x = 10;
    System.out.println("Inside changeTo10(): " + x);
  }

  static void modifyReference(ValueHolder valueHolder) {
    // The valueHolder variable is local. Changing its value doesn't affect the client's valueHolder instance.
    valueHolder = new ValueHolder(10);
  }

  static void modifyObject(ValueHolder valueHolder) {
    // valueHolder is the value of the reference, so here we are modifying the client's instance.
    valueHolder.value = 10;
  }

  static class ValueHolder {

    private int value;

    public ValueHolder(int value) {
      this.value = value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  public static void main(String[] args) {

    // Java is always pass-by-value.

    // Passing a primitive type to a method that modifies the passed
    // value doesn't change the value at the client level.
    int a = 5;
    changeTo10(a);
    System.out.println("Client level, after changeTo10(): " + a + "\n");  // Prints 5, not 10.

    ValueHolder valueHolder = new ValueHolder(5);
    System.out.println(valueHolder);

    // We pass the *value* of the reference...by value. We don't pass the reference itself, so a
    // function that modifies what the reference points to doesn't affect the client level instance.
    modifyReference(valueHolder);
    System.out.println(valueHolder);

    // But a function can can modify the passed object itself.
    modifyObject(valueHolder);
    System.out.println(valueHolder);
  }
}
