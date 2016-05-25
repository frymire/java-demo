
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

@SuppressWarnings("unused")
public class MultipleIterables implements Iterable<Integer> {
	
	// At some point, we might want to switch from an ArrayList (which is unsynchronized), 
	// to a Vector (which is synchronized) without the client knowing about it.
	private List<Integer> m_ints = new ArrayList<Integer>();
//	private Vector<Integer> m_ints = new Vector<Integer>();
		
	// We'd also like to be able to iterate over these
	private List<Double> m_doubles = new ArrayList<Double>();
	private List<String> m_strings = new ArrayList<String>();
	
	public MultipleIterables() {		
		m_ints.add(1); 				m_ints.add(2); 				m_ints.add(3);		
		m_doubles.add(4.0); 		m_doubles.add(5.0); 		m_doubles.add(6.0);		
		m_strings.add("seven"); 	m_strings.add("eight"); 	m_strings.add("nine");		
	}
	
	// We'll use the iterator for the whole class to provide access to the ints
	@Override public Iterator<Integer> iterator() { return m_ints.iterator(); }

	// Unfortunately, Java doesn't allow us to also add Iterable<Double> and Iterable<String> to the interface.  Instead, we
	// define inner classes, each with the sole job of implementing one of the new Iterable types and providing an iterator()
	// override the gives access to the desired data.
	private class Doubles implements Iterable<Double> { @Override public Iterator<Double> iterator() { return m_doubles.iterator(); } }	
	private class Strings implements Iterable<String> { @Override public Iterator<String> iterator() { return m_strings.iterator(); } }
	
	// Now, provide methods to allow clients to get an iterator to the data they want.  This is pretty tricky, because these 
	// methods return the private classes Doubles and Strings.  As shown in the main method below, the clients won't be able 
	// to see the private classes themselves, but they will still be able to use the iterators in the context of a for-loop.
	public Doubles getDoubles() { return new Doubles(); }
	public Strings getStrings() { return new Strings(); }
	
	public static void main(String[] args) {
		
		// Make an instance of the class, of course
		MultipleIterables myCI = new MultipleIterables();
		
		// Iterators allow clients to iterate over the private members without knowing 
		// whether they're stored as a Vector or ArrayList.
		for (Integer i: myCI) System.out.println(i);
		
		// Now, call the special iterator methods to be able to loop over the other collections
		for (Double d: myCI.getDoubles()) System.out.println(d);
		for (String s: myCI.getStrings()) System.out.println(s);		

		// NOTE: even though the getXXX() methods work above in the context of a for-loop, a client can't do this, 
		// because the inner classes are private.  (They happen to work here since I jammed the main into the class 
		// itself, but that was just so I could keep the demo code in one place.)
		//CustomIterables.Doubles myCIdoubles = myCI.getDoubles();
		//CustomIterables.Strings myCIstrings = myCI.getStrings();

	} // main
	
} // CustomIterables
