package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class ReadFromFile {
 
	public static void main(String[] args) {
 
		try (BufferedReader br = new BufferedReader(new FileReader("Let's Say Hi.txt")) )
		{
			String line;
			while ( (line = br.readLine() ) != null) { System.out.println(line); }
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
 
	} // main
	
} // class ReadFromFile