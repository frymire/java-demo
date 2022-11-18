package annotations;

@VeryImportant
public class ImportantThing {


//  @VeryImportant // can't use @VeryImportant here, because its @Target is defined for Types and Methods.
  @ImportantString
  String name;
  int age;

  public ImportantThing(String name) {
    this.name = name;
  }

  @VeryImportant
  @RunImmediately(times = 3)
  public void sayHello() {
    System.out.println("hello");
  }

  public void sayWorld() {
    System.out.println("world");
  }
}
