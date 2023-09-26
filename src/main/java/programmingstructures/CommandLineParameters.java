package programmingstructures;

public class CommandLineParameters {

  public static void main(String[] args) {
    
    System.out.println("Hi.");
    
    for(int i = 0; i < args.length; i++) {
      
      if(args[i].equals("--linux")) {
        System.out.println("Linux!");
      }
      
      System.out.println(i + ": " + args[i]);
    }
  }
}
