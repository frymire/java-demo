
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Timestamps {
  
  public static void main(String[] args) {
    
    System.out.println(Instant.now());

    DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSSSSSXXX" , Locale.US);
    String timeString = "2022-10-03 15:54:49.368678+00:00";
    
    LocalDateTime localDateTime = LocalDateTime.parse(timeString, format);
    System.out.println(localDateTime);
    
    ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("America/Toronto")); // America/Toronto, UTC
    System.out.println(zonedDateTime);
    
    Instant instant = zonedDateTime.toInstant();
    System.out.println(instant);
    System.out.println(instant.toEpochMilli());    
  }  
}
