package programmingstructures;

public class ParameterizedClass<T> {

	T m_prototype;

	// You wish you could do this, but T is unavailable due to type erasure.
	//public ParameterizedClass() { m_prototype = new T(); } // error

	// Instead, you have to build a prototype before making an instance of this class,
	// and send it in through the constructor.
	public ParameterizedClass(T prototype) { m_prototype = prototype; }

	public String toString() { return m_prototype.toString(); }

	public static void main(String[] args) {

		// Make an instance of ClassWithPrototype using a Double as the prototype
		final ParameterizedClass<Double> demo1 = new ParameterizedClass<>(5.0);
		System.out.println(demo1);

		final ParameterizedClass<Integer> demo2 = new ParameterizedClass<>(5);
		System.out.println(demo2);
	}
}
