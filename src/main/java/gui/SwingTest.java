package gui;

import javax.swing.JOptionPane;

public class SwingTest {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Hello world.");
		
		// Need to do this explicitly, since we're using a GUI.
		System.exit(0);

	}

}
