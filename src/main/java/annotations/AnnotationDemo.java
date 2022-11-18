package annotations;

// See here: https://www.youtube.com/watch?v=DkZr7_c9ry8&list=PL8asgL5ekA9lPqTUPRRiKD1jHs4k7Ic3N&index=8&t=707s

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@VeryImportant
public class AnnotationDemo {

  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

    ImportantThing thing1 = new ImportantThing("Edward");
    UnimportantThing thing2 = new UnimportantThing();

    // The class, not the instance, has the annotation. Can check whether it's present.
    System.out.println(thing1.getClass().isAnnotationPresent(VeryImportant.class));
    System.out.println(thing2.getClass().isAnnotationPresent(VeryImportant.class));

    // Use reflection to loop through all methods in a class and run it if is has @RunImmediately.
    System.out.println();
    for (Method method: thing1.getClass().getDeclaredMethods()) {

      boolean annotationPresent = method.isAnnotationPresent(RunImmediately.class);
      System.out.println(method.getName() + ": " + annotationPresent);

      if (annotationPresent) {
        // Extract the annotation as an instance so we can get its parameters
        RunImmediately annotation = method.getAnnotation(RunImmediately.class);
        for (int i = 0; i < annotation.times(); i++) { method.invoke(thing1); }
      }
    }

    // Loop over the fields and check for @ImportantString.
    System.out.println();
    for (Field field: thing1.getClass().getDeclaredFields()) {
      boolean annotationPresent = field.isAnnotationPresent(ImportantString.class);
      System.out.println(field.getName() + ": " + annotationPresent);
      if (annotationPresent) {
        Object fieldValue = field.get(thing1);

        // If the type check succeeds, stringValue takes the value.
        if (fieldValue instanceof String stringValue) {
          System.out.println(field.getName() + " = " + stringValue.toUpperCase());
        }

      }
    }

  }
}
