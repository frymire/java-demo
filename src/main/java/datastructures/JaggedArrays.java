package datastructures;

import java.util.Random;

public class JaggedArrays {

	public static void main(String[] args) {

		// Hard-coded method
//		int matrix[][] = { 
//				{44, 55, 66, 77}, 
//				{36}, 
//				{87, 97}, 
//				{68, 78, 88} 				
//		};

		// Procedural method
		int nRows = 4;
		int aMatrix[][] = new int[nRows][];
		
		Random rng = new Random();
		
		for (int i = 0; i < nRows; i++) {			
			aMatrix[i] = new int[1 + rng.nextInt(nRows)];
			for (int j = 0, nj = aMatrix[i].length; j < nj; j++) aMatrix[i][j] = rng.nextInt(10);
		}
			
		
		// Print it out with the enhanced for
		for (int[] row: aMatrix) {
			for (int entry: row) System.out.print(entry + "\t");
			System.out.println();
		}		
		
	}

}
