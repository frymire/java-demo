package datastructures;

import java.util.ArrayList;
//import java.util.List;


public class IntArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList< ArrayList<Integer> > wholeMatrix = new ArrayList< ArrayList<Integer> >();
		ArrayList<Integer> oneLine = null;
		
		for (int i = 0; i < 5; i++) {
			oneLine = new ArrayList<Integer>();		
			for (int tokenID = 0; tokenID < 5+i; tokenID++) { oneLine.add(tokenID); }			
			wholeMatrix.add(oneLine);
		}
		
		System.out.println("Done.");
		
	}

}
