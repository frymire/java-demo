package records;

// See here: https://www.youtube.com/watch?v=gJ9DYC-jswo&list=WL&index=38&t=331s

public class RecordDemo {

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
