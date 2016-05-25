package us.dac.frymire.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.MapMessage;

public class Log4JDemo {
	
	// Set up a logger for the class.  By default the name of the logger is given by Log4JDemo.class.getName() 
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		
		// Write a trace-level notice to the logger that we entered main()
		logger.entry();		
		
		// Put something on the thread context, so we can use it to filter messages
		ThreadContext.put("eventTypes", "boring");

		// Instantiate and execute a method on the other class
	    logger.trace("Call generateInsult().");
	    logger.info( (new Log4JDemoClass()).generateInsult(true, 6) );	    
	    
	    // Here come events at various priorities for the logger
	    logger.debug("Killing bugs.");
	    logger.info("1 + 2 = {}.", 1 + 2);
	    logger.warn("Wet floor.");
	    logger.error("Tilt!");
	    logger.fatal("We're all gonna die!");
	    
		// Change something on the thread context, so we can use it to filter messages
		ThreadContext.put("eventTypes", "exciting");   

	    // Print out some matrices.  First just use the toString method, then
	    // try a couple of different formats using a Message class
	    logger.trace("Print out some matrices.");
	    logger.info(new JaggedMatrix(4));
	    logger.info(new MatrixMessage(MatrixMessage.Format.ONE_LINE));
	    logger.info(new MatrixMessage(MatrixMessage.Format.RECTANGLE));
	    
	    
	    // Log a couple of MapMessages to demonstrate that we can filter on the fields
	    
	    MapMessage msg1 = new MapMessage();
	    msg1.put("type", "special");
	    msg1.put("userID", "frymire");
	    logger.info(msg1);

	    MapMessage msg2 = new MapMessage();
	    msg2.put("type", "normal");
	    msg2.put("userID", "yourMom");
	    logger.info(msg2);

	    
	    // Tell the logger that we're exiting (at trace level)
		logger.exit();

	}

}
