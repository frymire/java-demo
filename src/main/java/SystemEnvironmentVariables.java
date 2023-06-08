
public class SystemEnvironmentVariables {

  public static void main(String[] args) {
    // Print the path variable, one entry per line.
    System.out.println(System.getenv("path").replace(";", "\n"));
  }
}
