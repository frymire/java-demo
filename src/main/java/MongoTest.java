

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;


import java.io.IOException;

public class MongoTest {

	public static void main(String[] args) throws IOException {

		// Get a connection to the MongoDB server
		MongoClient mongoClient = new MongoClient();
		
		// Or, connect on a specific machine, with or without specifying a particular port number
//		MongoClient mongoClient = new MongoClient( "localhost" );
//		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

		// Or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
//		MongoClient mongoClient = new MongoClient(Arrays.asList(
//				new ServerAddress("localhost", 27017), 
//				new ServerAddress("localhost", 27018), 
//				new ServerAddress("localhost", 27019)));
		
		// Print out the available databases
		System.out.println("Available databases:");
		for (String s: mongoClient.getDatabaseNames() ) System.out.println(s); 

		// Get a connection to the MongoDB server for the "mydb" database.
//		DB db = mongoClient.getDB("mydb");
		DB db = mongoClient.getDB("test");

		// Print out the collection names in the database
		System.out.println("\nCollections in the current database:"); 
		for ( String s: db.getCollectionNames() ) System.out.println(s);
		
		// Get a particular collection
//		DBCollection coll = db.getCollection("test");
		DBCollection coll = db.getCollection("testCollection");

		// Build a document and add it to the collection 
		BasicDBObject doc = new BasicDBObject("name", "MongoDB");
		doc.append("type", "database");
		doc.append("count", 1);
		doc.append("info", new BasicDBObject("x", 203).append("y", 102));
		coll.insert(doc);

		// Get the first document in the collection and print it.
		DBObject myDoc = coll.findOne();
		System.out.println("\nFirst document: " + myDoc);

		// Add 10 documents with each key and value as matching integers numbered 0-9.  
		for (int i = 0; i < 10; i++) coll.insert( new BasicDBObject("i", i) );

		// Print the number of documents in the collection
		System.out.println("\nNumber of documents in the collection: " + coll.getCount() );
		
		// Let's remove one record
		coll.remove( new BasicDBObject("i", 7) );		
		
		// Print out all of the documents in the collection
		System.out.println("\nAll documents:");
		try ( DBCursor cursor = coll.find() ) {
			while( cursor.hasNext() ) System.out.println( cursor.next() );
		}
		
		// Find and print the documents for which the "i" field is 71
		System.out.println("\nAll documents with i = 71:");
		try ( DBCursor cursor = coll.find( new BasicDBObject("i", 71) ) ) {
		   while( cursor.hasNext() ) System.out.println( cursor.next() );
		}

		// Print out documents where 2 < i <= 5
		System.out.println("\nAll documents where 2 < i <= 5:");
		BasicDBObject query = new BasicDBObject("i", new BasicDBObject("$gt", 2).append("$lte", 5) );
		try (DBCursor cursor = coll.find(query) ) {
			while(cursor.hasNext()) System.out.println(cursor.next());
		} 

		// Delete the collection, if we don't need it in future runs
		coll.drop();
		
		// Close the connection to the MongoDB server.
		mongoClient.close();
		
	} // main

} // MongoTest
