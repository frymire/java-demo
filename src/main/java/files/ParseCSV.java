package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseCSV {

  public static void main(String[] args) {

    try (BufferedReader br = new BufferedReader(new FileReader("SomeData.csv")) ) {
      String line;
      while ( (line = br.readLine() ) != null) {
        System.out.println("Here comes a new line!!!");
        String[] tokens = line.split(",");
        for (int i = 0; i < tokens.length; i++) {
          System.out.println(" --> " + tokens[i]);			    
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }	
  
}