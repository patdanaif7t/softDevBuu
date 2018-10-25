
package tictactoe_g2_3;


import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.util.JSON;
import org.bson.Document;


public class Database {
    private static MongoClientURI uri;
    private static MongoClient client;
    private static MongoDatabase db;
    private static MongoCollection<Document> collection;

    public Database(){
        uri  = new MongoClientURI("mongodb://admin:abc123456@ds237922.mlab.com:37922/ox_59160117");
        client = new MongoClient(uri);
        db = client.getDatabase(uri.getDatabase());
    }
    
    public static void setCollection(String col) {
        collection = db.getCollection(col);
    }
    
    public static MongoCollection<Document> getCollection() {
        return collection;
    }
    
    public static boolean insert(Document doc) {
        try {
            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   
    public static Document find(String key,
            String value) {
        return collection.find(eq(key, value)).first();
    }
    
    public static Document find(String key,
            int value) {
        return collection.find(eq(key, value)).first();
    }
     public static FindIterable<Document> findAll(MongoCollection<Document> col) {
        return collection.find();
    }

//    Document find(String id, int id0) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    

     
}
