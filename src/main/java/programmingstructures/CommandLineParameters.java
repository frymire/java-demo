package programmingstructures;

public class CommandLineParameters {

  public static void main(String[] args) {
    for(int i = 0; i < args.length; i++) {
      System.out.println(i + ": " + args[i]);
      if(args[i].equals("--linux")) { System.out.println("Linux!"); }
    }
  }
}
