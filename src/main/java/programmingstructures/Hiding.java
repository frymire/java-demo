package programmingstructures;


public class Hiding {

	public class Parent {		
		protected String m_protectMe = "Parent";
		public void talk() { System.out.println(m_protectMe); }
	}

	public class Child extends Parent {
		
		// Without any warnings or annotations, Java let's you hide the m_protectMe in the Parent class
		private String m_protectMe = "Child";
		
		// This method will use the local value of m_protectMe, which hides that of the parent, but any methods
		// called on the parent will use *the parent's* value of m_protectMe.
		public void childSpeak() { System.out.println(m_protectMe); }
	}	
	
	public static void main(String[] args) {
		
		// The call to childSpeak() uses the child's copy of m_protectMe, while the call to talk(), a method of
		// the parent's class, will use the parent's copy of m_protectMe, which is different.  Java is horrible.
   		Child c = (new Hiding()).new Child();
   		c.childSpeak(); 	// "Child"
   		c.talk(); 			// "Parent"
   
   	} // main

} // Hiding
