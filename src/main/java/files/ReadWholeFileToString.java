package files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class ReadWholeFileToString {
  
  public static String readFile(String path, Charset encoding) throws IOException {
    String content = Files.lines(Paths.get(path), encoding).collect(Collectors.joining(System.lineSeparator()));
    return content;
  }

  public static void main(String[] args) {
    
    String filePath = "Let's Say Hi.txt";

    String content = null;
    try {
      content = readFile(filePath, StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(content);
  }
}
