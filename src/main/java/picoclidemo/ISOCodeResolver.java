package picoclidemo;

// Demo subcommands. See https://picocli.info/quick-guide.html

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

import java.util.Locale;

@Command(
        name = "ISOCodeResolver",
        subcommands = {
                SubcommandAsClass.class, // use separate classes for subcommands in larger applications
                CommandLine.HelpCommand.class // adds help as a command (but not version)
        },
        description = "Resolves ISO country codes (ISO-3166-1) or language codes (ISO 639-1/-2)"
)
// Since this doesn't implement Runnable or Callable, you must specify subcommand(s).
public class ISOCodeResolver {
  @Spec CommandSpec spec;

  @Command(name = "country", description = "Resolves ISO country codes (ISO-3166-1)")
  // When the 'country' command is parsed, this method implements the logic. No need for a separate run() method.
  void subCommandViaMethod(

          // Specify @Option and @Parameters annotations on subcommand method parameters.

          @Parameters(
            arity = "1..*",
            paramLabel = "<countryCode>",
            description = "country code(s) to be resolved (e.g. cn, fr, th)"
          )
          String[] countryCodes) {

    for (String code: countryCodes) {
      System.out.printf("%s: %s\n", code.toUpperCase(), new Locale("", code).getDisplayCountry());
    }
  }

  public static void main(String[] args) {
    args = new String[]{"help"};
//    args = new String[]{"country", "cn", "fr", "th"};
//    args = new String[]{"language", "de", "cs", "en"};
    int exitCode = new CommandLine(new ISOCodeResolver()).execute(args);
    System.exit(exitCode);
  }
}

@Command(name = "language", description = "Resolves one or more ISO language codes (ISO-639-1 or 639-2)")
class SubcommandAsClass implements Runnable {

  @Parameters(
          arity = "1..*", // having the arity range start at 1 implicitly makes the parameter required
          paramLabel = "<languageCode>",
          description = "language code(s) (e.g. de cs en)"
  )
  private String[] languageCodes;

  @Override
  // This gets called after the 'language' command is called and parsed.
  public void run() {
    for (String code: languageCodes) {
      System.out.printf("%s: %s\n", code.toLowerCase(), new Locale(code).getDisplayLanguage());
    }
  }
}
