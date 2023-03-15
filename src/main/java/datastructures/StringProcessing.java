package datastructures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessing {

  public static void main(String[] args) {

    String theString = "Hey, how are you doing?";
    System.out.println(theString.replace(",", ""));

// In IntelliJ, hit Alt-Enter and select Check RegExp to test a regex.
// Using static matches() method
    boolean regexResult1 = Pattern.matches(".s", "as");

    Pattern pattern = Pattern.compile(".s"); // . represents single character
    Matcher matcher = pattern.matcher("as");
    boolean regexResult2 = matcher.matches();

    System.out.println(regexResult1 + " " + regexResult2);
  }
}
