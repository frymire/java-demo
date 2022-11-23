package picoclidemo;

// See https://picocli.info/#_mutually_exclusive_options

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ArgGroup;

@Command(name = "exclusivedemo")
public class MutuallyExclusiveOptions implements Runnable {

  @ArgGroup(exclusive = true, multiplicity = "1")
  Exclusive exclusive;

  static class Exclusive {
    // Here, "required" implies within the *group*, not within the command.
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
//    args = new String[]{"-b=5", "-c=6"}; // error, since these options are mutually exclusive
    CommandLine commandLine = new CommandLine(new MutuallyExclusiveOptions());
    System.exit(commandLine.execute(args));
  }
}
