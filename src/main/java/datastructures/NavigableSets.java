package datastructures;

import java.util.*;

public class NavigableSets {

  public static void main(String[] args) {

    // NavigableSet eliminates duplicates and maintains order.
    NavigableSet<Integer> set = new TreeSet<>(Arrays.asList(5, 1, 9, 9, 3, 7));
    System.out.println(set); // [1, 3, 5, 7, 9] - automatically sorted, whereas Lists require manual sorting

    NavigableSet<Integer> scores = new TreeSet<>(Arrays.asList(85, 90, 78, 92, 88));
    System.out.println(scores.lower(90)); // below 90, returns 88
    System.out.println(scores.floor(90)); // up to 90, returns 90
    System.out.println(scores.ceiling(90)); // 90 or above, returns 90
    System.out.println(scores.higher(90)); // 90 or above, returns 92

    NavigableSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13));
    NavigableSet<Integer> subset = numbers.subSet(5, true, 10, false);
    System.out.println(subset); // [5, 10), so {5, 7, 9}
    System.out.println(numbers.tailSet(7, false)); // (9, +inf), so {9, 11, 13}
  }
}
