package us.dac.frymire.logging;

import java.io.Serializable;
import java.util.Random;

public class JaggedMatrix implements Serializable {
	
	private static final long serialVersionUID = 7310994409811373181L;
	int matrix[][];
	int nRows = 4;
	transient int transientValue;
	
	public JaggedMatrix(int nRows) {

		// Procedural method
		this.nRows = nRows;
		matrix = new int[nRows][];
		
		Random rng = new Random();
		
		for (int i = 0; i < nRows; i++) {			
			matrix[i] = new int[1 + rng.nextInt(nRows)];
			for (int j = 0; j < matrix[i].length; j++) matrix[i][j] = rng.nextInt(10);
		}
		
		transientValue = rng.nextInt(100);
			
	} // JaggedMatrix()
	
	@Override
	public String toString() {		
		
		// Start a new string
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n");
		
		// Print out the matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) { sb.append(matrix[i][j] + "\t"); }
			sb.append("\n");
		}
		
		sb.append("Transient value = " + transientValue + ".\n");
		
		// return the message as a string
		return sb.toString();
		
	} // toString

}  // JaggedMatrix
