package us.dac.frymire.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.Marker;

public class Log4JDemoClass {

  // Set up the logger using the class name
  private static final Logger logger = LogManager.getLogger(Log4JDemoClass.class.getName());

  // Define the markers for the events
  private static final Marker FAKE = MarkerManager.getMarker("Fake");
  private static final Marker REAL = MarkerManager.getMarker("Real");

  public String generateInsult(boolean testParam1, int testParam2) {

    // Write the entry event and method parameters to the logger
    logger.entry(testParam1, testParam2);

    // Here comes a mix of real and fake events for the logger
    logger.trace(REAL, "Let's get going.");
    logger.debug(FAKE, "Killing bugs.");
    logger.info(REAL, "1 + 2 = {}.", 1 + 2);
    logger.warn(FAKE, "Wet floor.");
    logger.error(REAL, "Tilt!");
    logger.fatal(FAKE, "We're all gonna die!");

    // Wrap the exit call around the Object to be returned
    return logger.traceExit("You're ugly.");

  } // generateInsult

} // Log4JDemoSubclass
