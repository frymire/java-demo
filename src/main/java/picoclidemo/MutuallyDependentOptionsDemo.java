package picoclidemo;

// See https://picocli.info/#_mutually_dependent_options

import picocli.CommandLine;

import java.util.Objects;

@CommandLine.Command(name = "co-occur")
public class MutuallyDependentOptionsDemo implements Runnable {

  @CommandLine.ArgGroup(exclusive = false) // implies default multiplicity = "0..1"
  Dependent dependent;

  static class Dependent {
    @CommandLine.Option(names = "-a", required = true) int a;
    @CommandLine.Option(names = "-b", required = true) int b;
    @CommandLine.Option(names = "-c", required = true) int c;
  }

  @Override
  public void run() {
    if (Objects.isNull(dependent)) {
      System.out.println("Dependent arguments not specified.");
      return;
    }
    System.out.println("dependent.a = " + dependent.a);
    System.out.println("dependent.b = " + dependent.b);
    System.out.println("dependent.c = " + dependent.c);
  }

  public static void main(String[] args) {
//    args = new String[]{"-b", "5"}; // error, if any argument is specified all three are required
    args = new String[]{"-a", "4", "-b=5", "-c=6"};
    CommandLine commandLine = new CommandLine(new MutuallyDependentOptionsDemo());
    System.exit(commandLine.execute(args));
  }
}
