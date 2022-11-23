package picoclidemo;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ArgGroup;

@Command(name = "exclusivedemo")
public class MutuallyExclusiveOptionsDemo implements Runnable {

  @ArgGroup(exclusive = true, multiplicity = "1")
  Exclusive exclusive;

  static class Exclusive {
    @Option(names = "-a", required = true) int a;
    @Option(names = "-b", required = true) int b;
    @Option(names = "-c", required = true) int c;
  }

  @Override
  public void run() {
    System.out.println("exclusive.a = " + exclusive.a);
    System.out.println("exclusive.b = " + exclusive.b);
    System.out.println("exclusive.c = " + exclusive.c);
  }

  public static void main(String[] args) {
    args = new String[]{"-b", "5"};
    CommandLine commandLine = new CommandLine(new MutuallyExclusiveOptionsDemo());
    System.exit(commandLine.execute(args));
  }
}
