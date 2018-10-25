/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_g2_3;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import static tictactoe_g2_3.Database.findAll;
import static tictactoe_g2_3.Database.getCollection;

public class UserDao {

    private static Database db;
    private static String avatarId;

    public UserDao() {
        db = new Database();
    }

    public boolean addUser(String Username, String Password, String Playname, String AvatarId) {
        
        db.setCollection("user");
        User user = new User(Username, Password, Playname, AvatarId);
        Document userData = new Document();
        userData.append("Username", user.getUsername());
        userData.append("Password", user.getPassword());
        userData.append("Playname", user.getPlayname());
        userData.append("AvatarId", user.getAvatar());
        
        try {
            db.insert(userData);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    public boolean getAllUser(Document doc) {
        try {
            // db.insert(doc);
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean getUser(String username) {
        try {
            Document user = db.find("Username", username);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isUserExist() {
        return true;
    }

    public boolean editUser(Document doc) {
        try {
            //db.insert(doc);
            return true;

        } catch (Exception e) {

            return false;
        }
    }

}
