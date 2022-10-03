
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.util.Calendar.*;

public class Calendars {

	public static void main(String[] args) {

		// Get the date, and print it in various formats
	    Calendar rightNow = Calendar.getInstance();
	    Calendar myBirthdate = new GregorianCalendar(1975, JANUARY, 24, 3, 10, 0);
	    System.out.printf("My birthdate: %tc\n", myBirthdate); // Fri Jan 24 02:10:45 EST 1975
	        
	    // Print out alternate time formats
	    System.out.printf("%tr\n", rightNow); // 09:54:36 AM
	    System.out.printf("%tT\n", rightNow); // 09:54:48
	    System.out.printf("%tR\n", rightNow); // 16:54
	    System.out.printf("%ts sec or %<tQ ms since 1 Jan 1970.\n\n", rightNow); // 1378822142 sec or 1378822142779 ms
	    
	    // Print out alternate date formats
	    System.out.printf("%tm/%<te/%<tY\n", rightNow); // 09/05/2013
	    System.out.printf("%tm/%<td/%<ty\n", rightNow); // 09/5/13	    
	    System.out.printf("%tD\n", rightNow); 			// 09/5/13
	    System.out.printf("%tF\n", rightNow); 			// 2013-09-10	    
	    System.out.printf("%tA, %<tB %<te, %<tY\n", rightNow); // Tuesday, September 10, 2013
	    System.out.printf("%ta, %<te %<tb %<tY\n", rightNow);  // Tue, 10 Sep 2013
	    System.out.printf("%ta, %<td %<tb %<tY\n", rightNow);  // Tue, 5 Sep 2013	    

	    // Special cases
	    System.out.printf("It is day #%1$tj of the year.\n", rightNow); // It is day #253 of the year.
	    
	} // main

} // CalendarDemo

/*   
The following conversion characters are used for formatting times: 

'H'  Hour of the day for the 24-hour clock, formatted as two digits with a leading zero as necessary i.e. 00 - 23.  
'I'  Hour for the 12-hour clock, formatted as two digits with a leading zero as necessary, i.e. 01 - 12.  
'k'  Hour of the day for the 24-hour clock, i.e. 0 - 23.  
'l'  Hour for the 12-hour clock, i.e. 1 - 12.  
'M'  Minute within the hour formatted as two digits with a leading zero as necessary, i.e. 00 - 59.  
'S'  Seconds within the minute, formatted as two digits with a leading zero as necessary, i.e. 00 - 60 ("60" is a special value required to support leap seconds).  
'L'  Millisecond within the second formatted as three digits with leading zeros as necessary, i.e. 000 - 999.  
'N'  Nanosecond within the second, formatted as nine digits with leading zeros as necessary, i.e. 000000000 - 999999999.  
'p'  Locale-specific morning or afternoon marker in lower case, e.g."am" or "pm". Use of the conversion prefix 'T' forces this output to upper case.  
'z'  RFC 822 style numeric time zone offset from GMT, e.g. -0800.  
'Z'  A string representing the abbreviation for the time zone. The Formatter's locale will supersede the locale of the argument (if any).  
's'  Seconds since the beginning of the epoch starting at 1 January 1970 00:00:00 UTC, i.e. Long.MIN_VALUE/1000 to Long.MAX_VALUE/1000.  
'Q'  Milliseconds since the beginning of the epoch starting at 1 January 1970 00:00:00 UTC, i.e. Long.MIN_VALUE to Long.MAX_VALUE.  

The following conversion characters are used for formatting dates:
   
'B'  Locale-specific full month name, e.g. "January", "February".  
'b'  Locale-specific abbreviated month name, e.g. "Jan", "Feb".  
'h'  Same as 'b'.  
'A'  Locale-specific full name of the day of the week, e.g. "Sunday", "Monday"  
'a'  Locale-specific short name of the day of the week, e.g. "Sun", "Mon"  
'C'  Four-digit year divided by 100, formatted as two digits with leading zero as necessary, i.e. 00 - 99  
'Y'  Year, formatted as at least four digits with leading zeros as necessary, e.g. 0092 equals 92 CE for the Gregorian calendar.  
'y'  Last two digits of the year, formatted with leading zeros as necessary, i.e. 00 - 99.  
'j'  Day of year, formatted as three digits with leading zeros as necessary, e.g. 001 - 366 for the Gregorian calendar.  
'm'  Month, formatted as two digits with leading zeros as necessary, i.e. 01 - 13.  
'd'  Day of month, formatted as two digits with leading zeros as necessary, i.e. 01 - 31  
'e'  Day of month, formatted as two digits, i.e. 1 - 31.
  
*/
