import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriters {

	// This can write to whatever the PrintWriter is set up with, whether it's the console, a file, a socket, etc.
	private static void sayHi(PrintWriter pw) { pw.println("Hello."); }	

	public static void main(String[] args) {

		// Let's write something to the console elaborately
		sayHi( new PrintWriter(System.out, true) );

		// Declare a file.  NOTE: You don't close File objects.
		File myFile = new File("Let's Say Hi.txt");

		// Here's how to print using the write() method of a FileWriter.  FileWriter has no printXXX() methods, which 
		// is why we need the PrintWriter below. Setting the second parameter to false gives us a clean file each time.
		try (FileWriter fw = new FileWriter(myFile, false)) {
			fw.write("I'm writing this using a FileWriter.\n");   		
		} catch (IOException e) {
			System.err.println(e);	    	
		}

		// Now, with the PrintWriter.  Setting the second parameter to true appends the file, instead of starting a new one.  
		try (PrintWriter pw = new PrintWriter( new FileWriter(myFile, true) ) ) {   		    	
			sayHi(pw);
		} catch (IOException e) {
			System.err.println(e);	    	
		}

		// If you always want to start a new file each time, you don't need the FileWriter at all.
		try (PrintWriter pw = new PrintWriter("Say Hi Once.txt"); ) {
			sayHi(pw);    	
		} catch (IOException e) {
			System.err.println(e);	    	
		}

		// You shouldn't do this, because you won't be able to close the PrintWriter, and the file will appear blank.
//		try {
//			sayHi( new PrintWriter(myFile) );    		
//		} catch (Exception e) {
//			System.err.println(e);
//		}

	} // main

} // PrintWriterDemo