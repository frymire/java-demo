/**
 * 
 */
package us.dac.frymire.unittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import us.dac.frymire.unittest.CatLeap;


/**
 * @author mark.e.frymire
 *
 */
public class CatLeapTest {

	//Make a new CatLeap object pointer.
	CatLeap my_cl;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		//Initialize the my_cl pointer to a newly constructed CatLeap object.
		my_cl = new CatLeap();		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link us.dac.frymire.unittest.CatLeap#CatLeap()}.
	 */
	@Test
	public final void testCatLeap() {
		
		System.out.println("This test doesn't really do anything.");
		//fail("Your code has failed.  Therefore, you are a failure.");		
	}

	/**
	 * Test method for {@link us.dac.frymire.unittest.CatLeap#getName()}.
	 */
	@Test
	public final void testGetName() {
		
		//At this point, we should have the default string for the name.  Check it...
		//testSetName();
		assertEquals("Unknown Name.", my_cl.getName());		
	}

	/**
	 * Test method for {@link us.dac.frymire.unittest.CatLeap#setName(java.lang.String)}.
	 */
	@Test
	public final void testSetName() {

		//Set its name.
		my_cl.setName("Corner Cat, baby!");
		
		//Test that is equals "Corner Cat, baby!".
		assertEquals("Corner Cat, baby!", my_cl.getName());
	}

	/**
	 * Test method for {@link us.dac.frymire.unittest.CatLeap#getMaximumBooks()}.
	 */
	@Test
	public final void testGetMaximumBooks() {
		
		//Check that the number of maximum books is set to the default of 3.
		assertEquals(3, my_cl.getMaximumBooks());
	}

	/**
	 * Test method for {@link us.dac.frymire.unittest.CatLeap#setMaximumBooks(int)}.
	 */
	@Test
	public final void testSetMaximumBooks() {

		//Change the number of maximum books to 10.
		my_cl.setMaximumBooks(10);
		
		//Check that it actually is 10;
		assertEquals(10, my_cl.getMaximumBooks());		
	}
	
	/**
	 * Test method for {@link us.dac.frymire.unittest.CatLeap#setMaximumBooks(int)}.
	 */
	@Test
	public final void testDistanceBetweenPoints() {
		
		System.out.println("Distance is " + CatLeap.distanceBetweenPoints(0.0, 0.0, 1.0 ,1.0));
				
		assertEquals(1.4142135623730951, CatLeap.distanceBetweenPoints(0.0, 0.0, 1.0 ,1.0), 0.0001);		
	}

}
