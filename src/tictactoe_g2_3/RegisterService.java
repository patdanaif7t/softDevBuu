/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_g2_3;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import static tictactoe_g2_3.Database.findAll;
import static tictactoe_g2_3.Database.getCollection;

/**
 *
 * @author firstx
 */
public class RegisterService {

    private static Database db;
    private static MongoCollection<Document> user;

    public RegisterService() {
        db = new Database();
    }

    public boolean checkUserExist(String User) {//checkUserExist  checkID
        db.setCollection("user");
        try {

            Document myDoc = user.find(eq("ID", User)).first();
            System.out.println(myDoc.toJson());
            return true;

        } catch (Exception e) {
            //  System.out.println("ดักว่าไอดีไม่ซ้ำ");
            //  clearInpurField();
            //ดักไอดีซ้ำและคืนค่า Boolean
            return false;
        }
    }

    public boolean isPasswordMatching(String password,
            String confirmPassword) {

        if (password.equals(confirmPassword)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isFill(String field) {
        if (field.equals("")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isFieldAllFilled(String username,
            String playerName,
            String password,
            String confirmPassword) {
        if (isFill(username)
                || isFill(playerName)
                || isFill(password)
                || isFill(confirmPassword)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isLengthCorrect(String str) {
        if (str.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

}
