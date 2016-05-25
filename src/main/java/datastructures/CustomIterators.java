package datastructures;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class CustomIterators<Type> implements Iterable<Type> {
	
	// Store some data in a jagged 2D List of Lists	
	List< List<Type> > data = new ArrayList<>();
	
	// Let the client add a new row of data
	public void addRow(List<Type> row) { data.add(row); }
	
	// Define an iterator using a private class	
	private class CustomIteratorDemoIterator implements Iterator<Type> {
		
		int row = 0;
		int col = 0;
		
		@Override public boolean hasNext() { return row < data.size(); }

		@Override public Type next() { 
			
			// Get the entry and increment the column
			Type entry = data.get(row).get(col++);	
			
			// If we ran out of columns, go to the beginning of the next row
			if (col == data.get(row).size()) { col = 0; row++; }
			
			// Return the entry
			return entry;
			
		} // next

		@Override public void remove() { }

	} // CustomIteratorDemoIterator

	// Override the iterator() method using the private class
	@Override public Iterator<Type> iterator() { return new CustomIteratorDemoIterator(); }

	// Loop over an instance of the class
	public static void main(String[] args) {
		
		// Make some rows of data to add				
		List<Integer> row1 = new ArrayList<>(); row1.add(1); row1.add(2);
		List<Integer> row2 = new ArrayList<>(); row2.add(3); row2.add(4); row2.add(5);
		
		// Make an instance of the class and add the data rows
		CustomIterators<Integer> matrix = new CustomIterators<>();
		matrix.addRow(row1);
		matrix.addRow(row2);			
		
		// Loop over the matrix using the custom iterator, and print out each entry on its own line
		for (Integer i: matrix) System.out.println(i);
		
	} // main

} // CustomIteratorDemo
