package programmingstructures;

public class Hiding {

	public static class Parent {
		protected String protectMe = "Parent";
		public void talk() { System.out.println(protectMe); }
	}

	public static class Child extends Parent {

		private final String protectMe = "Child"; // hides Parent.protectMe!
		
		// This method use Child.protectMe, but parent methods called on child instances will use Parent.protectMe.
		public void childSpeak() { System.out.println(protectMe); }
	}	
	
	public static void main(String[] args) {
		Child child = new Child();
   	child.childSpeak(); // uses the child's copy of protectMe -> "Child"
   	child.talk(); // uses the parent's copy of protectMe -> "Parent" !
	}
}
