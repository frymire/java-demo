package files;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

public class TestTika {

	public static void main(String[] args) {

		String inputFolderName = "Tika Test Files";
		String outputFolderName = "Tika_Test_Outputs";

		// Set up an instance of Tika to do the parsing for us
		Tika myTika = new Tika();

		// Loop over the files in the input folder
		for (final File file: new File(inputFolderName).listFiles() ) {

			// If the file is a directory, we'll just skip it, in this demo
			if (!file.isFile()) continue;

			String filename = file.getName();			
			System.out.println(filename);
			
			try (PrintWriter outFile = 
					new PrintWriter(new FileWriter(outputFolderName  + File.separator + filename + ".txt") )  ) {

				// Use Tika to parse the file, and write it to the output file
				outFile.print(myTika.parseToString(file));
				
			} catch (IOException | TikaException e) {
				e.printStackTrace();
			}
		}
	}
}
