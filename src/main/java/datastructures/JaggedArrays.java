package datastructures;

import java.util.Random;

public class JaggedArrays {

	public static void main(String[] args) {

		// Hard-coded
//		int[][] matrix = {
//				{44, 55, 66, 77}, 
//				{36}, 
//				{87, 97}, 
//				{68, 78, 88} 				
//		};

		// Procedural
		int nRows = 4;
		int[][] matrix = new int[nRows][];
		
		Random rng = new Random();
		
		for (int i = 0; i < nRows; i++) {			
			matrix[i] = new int[1 + rng.nextInt(nRows)];
			for (int j = 0, nj = matrix[i].length; j < nj; j++) matrix[i][j] = rng.nextInt(10);
		}

		// Print it out with the enhanced for
		for (int[] row: matrix) {
			for (int entry: row) System.out.print(entry + "\t");
			System.out.println();
		}
	}
}
