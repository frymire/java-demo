package programmingstructures;



public class NonStaticMainMethods {
	
	private int x = 0;

	public void aNonStaticMethod() { System.out.println("Executing a non-static method.  X is " + x++); }

	public static void main(String[] args) {
		
		// You can't do this, because main() is static and can't call a non-static method
		//aNonStaticMethod();
		
		// But you can do this instead, believe it or not
		NonStaticMainMethods myMainObject = new NonStaticMainMethods();		
		myMainObject.aNonStaticMethod();
		myMainObject.aNonStaticMethod();
	}

}
