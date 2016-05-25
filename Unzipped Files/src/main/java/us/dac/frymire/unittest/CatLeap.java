package us.dac.frymire.unittest;


/**
 * 
 * @author mark.e.frymire
 *
 */

public class CatLeap {

	//Fields
	private String 	m_name; 			//Name of the person
	protected int 	m_maximumBooks; 	//Most books the person can check out
	
//	private FileReader filereader = new FileReader("LocalFile.txt");
	
	//Constructors
	public CatLeap(){
		m_name = "Unknown Name.";
		m_maximumBooks = 3;
	}
	
	//Methods
	protected String getName(){
		return m_name;
	}
	
	public void setName(String anyName) {
		m_name = anyName;
	}

	public int getMaximumBooks() {
		return m_maximumBooks;
	}

	public void setMaximumBooks(int maximumBooks) {
		m_maximumBooks = maximumBooks;
	}
	
	static double distanceBetweenPoints( double x1, double y1,
										 double x2, double y2 ) {
	    double xdist = x1 - x2;
	    double ydist = y1 - y2;

	    return Math.sqrt(xdist * xdist + ydist * ydist);
	}
			
}
