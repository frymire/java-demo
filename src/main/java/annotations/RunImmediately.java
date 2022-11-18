package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunImmediately {
  // Specify parameters as methods, fields. Can only be a primitive, class, string, or array types.
  int times() default 1; // specify a default of 1
}
