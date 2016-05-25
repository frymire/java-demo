
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class JSON {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Let's build and print a JSON object	
	    JSONObject builtObject = new JSONObject();	
	    builtObject.put("name", "foo");
	    builtObject.put("num", 100); 
	    builtObject.put("balance", 1000.21); 
	    builtObject.put("is_vip", true); 
	    System.out.println(builtObject + "\n");
	      
	    // Now let's try to parse a string into a JSON object
	    JSONParser parser = new JSONParser();
            
	    try {
	    	
	    	JSONArray array = (JSONArray) parser.parse("[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]");
	    	JSONObject parsedObject = (JSONObject) array.get(1);

	    	System.out.println("The 2nd element of array: " + array.get(1) + "\n");
	    	System.out.println("Field \"1\": " + parsedObject.get("1") + "\n");
	    	
	    	System.out.println(parser.parse("{}") + "\n");
	    	System.out.println(parser.parse("[5,]") + "\n");
	    	System.out.println(parser.parse("[5,,2]") + "\n");
	    	
	    } catch(ParseException pe) {
	    	
	    	System.out.println("position: " + pe.getPosition());
	    	System.out.println(pe);
         
	    } // try
	      
	} // main
	
} // JSONDemo
