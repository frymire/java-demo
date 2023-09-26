package datastructures;

// See here: https://www.youtube.com/watch?v=gJ9DYC-jswo&list=WL&index=38&t=331s

public record EmployeeRecord(String name, int employeeNumber) {

  // Records implicitly extend the Java Record class, so they can't extend other classes, since
  // multiple inheritance is not allowed. Interfaces are okay. Records are also implicitly final.

  // Parameters automatically added as private members with getters.
  // Instances are immutable. No setters are generated.

  // Add static fields as usual.
  public static final String DEFAULT_EMPLOYEE_NAME = "George";

  // A canonical constructor is created automatically, but you can override it.
//  public EmployeeRecord(String name, int employeeNumber) {
//    // Maybe do validation or something.
//    this.name = name;
//    this.employeeNumber = employeeNumber;
//  }

  // Since it seems redundant to assign the constructor parameters for a record, you can instead
  // use a "compact" constructor, in which the assignment happens automatically. This has the same
  // behavior as the previous one, even without the explicit parameter specification and assignment.
//  public EmployeeRecord {
//    // Maybe do validation or something.
//    // (Fields automatically set.)
//  }

  // Instance fields are not allowed, except in the parameter list.
  // private String something; // compile-time error

  // Add methods as usual.
  public String nameInUpperCase() {
    return name.toUpperCase();
  }

  public static void printWhatever() {
    System.out.println("Whatever, dude.");
  }

  public static void main(String[] args) {

    EmployeeRecord record1 = new EmployeeRecord("Frymire", 54321); // canonical constructor
    EmployeeRecord record2 = new EmployeeRecord("Frymire", 54321);
    EmployeeRecord record3 = new EmployeeRecord("Frymire", 12345);

    // auto-generated toString()
    System.out.println(record1);
    System.out.println(record1.nameInUpperCase());
    EmployeeRecord.printWhatever();

    // equals() returns true if the fields match, it doesn't have to be the same instance.
    System.out.println(record2.equals(record2));
    System.out.println(record2.equals(record3));
  }
}
