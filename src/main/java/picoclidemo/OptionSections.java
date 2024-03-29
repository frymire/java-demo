package picoclidemo;

// Demo option sections in usage help. See https://picocli.info/#_option_sections_in_usage_help.

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ArgGroup;

@Command(name = "sectiondemo", description = "Section demo")
public class OptionSections {

  // Append %n to the heading field to insert a newline between sections.
  // Though we specify this second section first in the code, the order field ensures the correct placement.
  @ArgGroup(validate = false, heading = "This is the second section%n", order = 2)
  Section2 section2;

  static class Section2 {
    @Option(names = "-x", description = "Option X") int x;
    @Option(names = "-y", description = "Option Y") int y;
    @Option(names = "-z", description = "Option Z") int z;
  }

  @ArgGroup(validate = false, heading = "This is the first section%n", order = 1)
  Section1 section1;

  static class Section1 {
    @Option(names = "-a", description = "Option A") int a;
    @Option(names = "-b", description = "Option B") int b;
    @Option(names = "-c", description = "Option C") int c;
  }

  public static void main(String[] args) {
    new CommandLine(new OptionSections()).usage(System.out);
  }
}
