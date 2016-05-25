package programmingstructures;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

import us.dac.frymire.logging.JaggedMatrix;

public class Serialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Make a JaggedMatrix and print it to the console
		JaggedMatrix jm1 = new JaggedMatrix(4);
		JaggedMatrix jm2 = new JaggedMatrix(4);
		System.out.println(jm1);
		System.out.println(jm2);

		// Let's try to serialize it
		try (FileOutputStream fileOut = new FileOutputStream("employee.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut) )   {
			out.writeObject(jm1);
			out.writeObject(jm2);
			System.out.printf("Serialized data is saved in employee.ser");	         
		} catch(IOException i) {
			i.printStackTrace();
		}


		// Now let's try to read it back in
		JaggedMatrix jm3 = null, jm4 = null;
		try (
			FileInputStream fileIn = new FileInputStream("employee.ser"); 
			ObjectInputStream in = new ObjectInputStream(fileIn) 
		) {
			jm3 = (JaggedMatrix) in.readObject();
			jm4 = (JaggedMatrix) in.readObject();
		} catch(IOException i) {
			i.printStackTrace();
			return;
		} catch(ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}

		// Now print the object read in from file.  Note that the transient value is 0.
		System.out.println(jm3);
		System.out.println(jm4);

	}

}
