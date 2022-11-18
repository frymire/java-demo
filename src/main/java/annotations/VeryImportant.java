package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})  // Specifies the Java elements this annotation can be used on
@Retention(RetentionPolicy.RUNTIME)  // Keeps the annotation through runtime. SOURCE or CLASS elide it sooner.
public @interface VeryImportant {
}
