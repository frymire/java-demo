package us.dac.frymire.logging;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.FileHandler;

public class JavaLogger {

  private static Logger logger = Logger.getLogger("us.dac.frymire");
  private Handler fh;

  public JavaLogger() {

    try {
      fh = new FileHandler("LogDebug Log.xml");			 
    } catch (IOException e) {
      e.printStackTrace();
    }

    Logger.getLogger("").addHandler(fh);
    Logger.getLogger("us.dac.frymire").setLevel(Level.FINEST);		 
  }


  public static void main(String[] args) {

    logger.entering("JavaLogger", "main"); // Doesn't seem to work.

    logger.fine("Mark.");
    logger.finer("Mark Frymire");
    logger.finest("Mark Edward Frymire");
    logger.info("I like pizza.");

    try {			
      throw(new Exception("You suck."));			
    } catch (Exception ex) {			
      logger.log(Level.WARNING, "trouble here", ex);
      // Or similarly... logger.warning("trouble here\n" + ex);
      logger.severe("You screwed up big time.");		
    }	
  }
} 
