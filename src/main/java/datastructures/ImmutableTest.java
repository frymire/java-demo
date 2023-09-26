package datastructures;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

//import com.google.common.collect.ImmutableList; // Guava library

public class ImmutableTest {

	public static void main(String[] args) {
		
		// You can make an array final, but you can still modify the elements
		final int[] array = new int[] {0, 1, 2, 3};
		printArray(array);
		array[0] = 42;
		printArray(array);
		System.out.println();
		
		// Now use a list, so we can try to make it unmodifiable		
		List<Integer> originalItems = Arrays.asList(4, 5, 6, 7);
		List<Integer> immutableItems = Collections.unmodifiableList(originalItems);
		printList(originalItems);
		printList(immutableItems);

		// We're not allowed to change elements using the immutableItems reference, but we 
		// can still change them through the originalItems reference, which is mutable.  
		//immutableItems.set(0, 42); // run-time error
		originalItems.set(0, 42);
		printList(originalItems);
		printList(immutableItems);
		System.out.println();

		// Therefore, Java's supposedly-immutable data structures shouldn't be trusted.
		// Google's Guava library is reportedly a safer and easier way to make immutable lists
//		ImmutableList<Integer> guavaItems = ImmutableList.of(1,2,3,4);
//		for (int i: guavaItems) System.out.print(i + " "); System.out.println();
		//guavaItems.set(0, 42); // run-time error
	}

	private static void printList(List<Integer> integers) {
		for (int i: integers) System.out.print(i + " ");
		System.out.println();
	}

	private static void printArray(int[] array) {
		for (int i: array) System.out.print(i + " ");
		System.out.println();
	}
}
