package datastructures;


public class StringFormatting  {
	
	public static void main(String[] args) {				
		
	    // Here's how to print a formatted string to the System.out.  Both format() and printf() seem equivalent.
	    System.out.format("My name is %s.  ", "Mark");
	    System.out.printf("I like %s and %s.\n", "pizza", "beer");
	    
		// Alternatively, you can set up a PrintWriter.  I guess this effectively just gives
	    // you an alias for System.out.  Let's print a string, integer, and double.
		System.out.println("This is a string."); 
		System.out.println(-7); 
		System.out.println(4.5e-7);
		
	    // Print a formatted string.  The format specifiers have the following syntax: 
		//   %[argument_index$][flags][width][.precision]conversion		  
		// Using a capital letter for a conversion upper cases the string.
		// using < in place of {#}$ to refer to the previous argument
	    System.out.printf("\n%s, %s, %S\n", "first", "second", "third");
	    System.out.printf("%3$s, %1$s, %2$s\n", "first", "second", "third");
	    System.out.printf("%1$s, %<s, %<s, %2$s, %3$s\n\n", "first", "second", "third");
	    
	    // Left justify with '-', Zero pad with '0'
	    System.out.printf("*** %d ***\n", 123);
	    System.out.printf("*** %5d ***\n", 123);
	    System.out.printf("*** %-5d ***\n", 123);
	    System.out.printf("*** %05d ***\n\n", 123);
	    
	    System.out.printf("*** %f ***\n", 123.4);
	    System.out.printf("*** %f ***\n", (float) 123.4);
	    System.out.printf("*** %f ***\n", (double) 123.4);
	    System.out.printf("*** %2.1f ***\n", 123.4);
	    System.out.printf("*** %7.1f ***\n", 123.4);
	    System.out.printf("*** %-7.1f ***\n", 123.4);
	    System.out.printf("*** %07.1f ***\n\n", 123.4);

	    
	    // Let's format Avogadro's number in scientific notation
	    System.out.printf("%e\n", 6.0221413e+23);
	    System.out.printf("%g (rounded)\n", 6.0221413e+23);
	    System.out.printf("%5.2e\n\n", 6.0221413e+23);	    
	    	    	    
	    // Print the numbers 0-64 in octal format
	    for (int i = 0; i < 8; i++) {
	    	for (int j = 0; j < 8; j++) System.out.printf("%2o ", 8*i + j);
	    	System.out.println();
	    }
	    System.out.println();

	    // Print the numbers 0-255 in hexadecimal format
	    for (int i = 0; i < 16; i++) {
	    	for (int j = 0; j < 16; j++) System.out.printf("%2X ", 16*i + j);
	    	System.out.println();
	    }
	    System.out.println();

	    
	    // Add group separators with ",".  The '(' formats negative numbers with parentheses rather 
	    // than a minus sign. ' ' reserves a space in front of positive values, and '+'uses a plus	   
	    System.out.format("$ %,.2f	$ %(,.2f\n", -1234567.89, -1234567.89);
	    System.out.format("$ %, .2f	$ %, .2f\n", 1234567.89, -1234567.89);	    
	    System.out.format("$ %,+.2f	$ %,+.2f\n", 1234567.89, -1234567.89);	    
	    
	}

}
