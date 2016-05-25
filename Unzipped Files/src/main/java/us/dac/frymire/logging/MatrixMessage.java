package us.dac.frymire.logging;

import org.apache.logging.log4j.message.Message;


public class MatrixMessage implements Message {
	
	private static final long serialVersionUID = 201309051417L;

	public enum Format { ONE_LINE, RECTANGLE };	
	private Format format;
	
	private int[][] matrix = { {1, 2}, {3, 4, 5} };
	
	public MatrixMessage(Format theFormat) { this.format = theFormat; }

	
	public String getFormattedMessage() {
		
		// Start a new string
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n");
		
		// Loop through the matrix, adding a carriage return, if appropriate
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) sb.append(matrix[i][j] + "\t");			
			if (format == Format.RECTANGLE) sb.append("\n");						
		}			

		// return the message as a string
		return sb.append("\n").toString();				

	} // getFormattedMessage

	
	@Override
	public String getFormat() { return null; }

	@Override
	public Object[] getParameters() { return null; }

	@Override
	public Throwable getThrowable() { return null; }

	
} // MatrixMessage
