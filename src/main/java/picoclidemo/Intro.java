package picoclidemo;

// Quick start demo. See https://picocli.info/quick-guide.html.

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

@Command(
        name = "ASCIIArt",
        version = "ASCIIArt 1.0",
        mixinStandardHelpOptions = true // adds --help and --version options
)
public class Intro implements Runnable { // by implementing Runnable or Callable, the class becomes a CLI command

  @Option(names = { "-s", "--font-size" }, description = "Font size") // add an option to the CLI
  int fontSize = 14;

  @Parameters( // Add a positional parameter to the CLI
          paramLabel = "<word>",
          defaultValue = "Hello, picocli", // injects this value into 'words' variable
          description = "Words to be translated into ASCII art."
  )
  private String[] words;

  @Override
  // Business logic to be run after parsing the command line.
  public void run() {

    // https://stackoverflow.com/questions/7098972/ascii-art-java
    BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
    Graphics graphics = image.getGraphics();
    graphics.setFont(new Font("Dialog", Font.PLAIN, fontSize));
    Graphics2D graphics2D = (Graphics2D) graphics;
    graphics2D.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics2D.drawString(String.join(" ", words), 6, 24);

    for (int y = 0; y < 32; y++) {
      StringBuilder builder = new StringBuilder();
      for (int x = 0; x < 144; x++)
        builder.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
      if (builder.toString().trim().isEmpty()) continue;
      System.out.println(builder);
    }
  }

  public static void main(String[] args) {

//    args = new String[]{"-h"};
    args = new String[]{"--font-size=15", "Hello", "picocli"};

    CommandLine commandLine = new CommandLine(new Intro());
    commandLine.usage(System.out);

    // CommandLine.execute() parses the command line, handles errors, handles usage/version requests, and invokes run().
    int exitCode = commandLine.execute(args);
    System.exit(exitCode);
  }
}
