

public class Prototypes {

	public class ClassWithPrototype<T> {
		
		T m_prototype;
		
		// You wish you could do this, but Java doesn't let you.
		//public ClassWithPrototype() { m_prototype = new T(); } // error
		
		// Instead, you have to build a prototype before making an instance of this class, and
		// send it in through the constructor.
		public ClassWithPrototype(T prototype) { m_prototype = prototype; }
		
		public String toString() { return m_prototype.toString(); }
		
	}
	
	public static void main(String[] args) {
		
		// Make an instance of ClassWithPrototype using a double as the prototype
		System.out.println( (new Prototypes()).new ClassWithPrototype<>(5.0) );		
	}

}
