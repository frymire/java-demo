// Adapted from https://dzone.com/articles/how-to-implement-get-and-post-request-through-simp

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RESTDemo {
  
  public static void sendGetRequest() throws IOException, ParseException {

    URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("userId", "a1bcdef");
    int responseCode = connection.getResponseCode();

    if (responseCode != HttpURLConnection.HTTP_OK) {
      System.out.println("GET Failed");
      return;
    }

    BufferedReader fromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String line = null;
    StringBuffer response = new StringBuffer();
    while ((line = fromServer.readLine()) != null) {
      response.append(line);
    }
    fromServer.close();

    String responseText = response.toString();
    System.out.println("JSON String Result: " + responseText);
  
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonMessage = (JSONObject) jsonParser.parse(responseText);
    String title = (String) jsonMessage.get("title");
    String body = (String) jsonMessage.get("body");
    System.out.println("Title: " + title);
    System.out.println("Body: " + body);
  }

  public static void sendPostRequest() throws IOException {

    URL url = new URL("https://jsonplaceholder.typicode.com/posts");

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("POST");
    connection.setRequestProperty("userId", "a1bcdefgh");
    connection.setRequestProperty("Content-Type", "application/json");

    connection.setDoOutput(true);
    OutputStream toServer = connection.getOutputStream();
    String postJSON = "{\"id\": 101, \"title\": \"Test Title\", \"body\": \"Test Body\"}";
    System.out.println(postJSON);
    toServer.write(postJSON.getBytes());
    toServer.flush();
    toServer.close();

    int responseCode = connection.getResponseCode();
    System.out.println("POST response code: " + responseCode);
    System.out.println("POST response message: " + connection.getResponseMessage());
    if (responseCode != HttpURLConnection.HTTP_CREATED) {
      System.out.println("POST Failed");
      return;
    }

    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String line;
    StringBuffer response = new StringBuffer();
    while ((line = in.readLine()) != null) {
      response.append(line);
    }
    in.close();
    System.out.println(response.toString());
  }
  
  public static void main(String[] args) throws IOException, ParseException {
    RESTDemo.sendGetRequest();
    System.out.println();
    RESTDemo.sendPostRequest();
  }
}
