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
    private static User user;

    public UserDao() {
        db = new Database();
        db.setCollection("user");
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

    public User getUser(String username) {
        Document userQuery = db.find("Username", username);
        user = new User();
        user.setUsername(userQuery.get("Username").toString());
        user.setPassword(userQuery.get("Password").toString());
        user.setPlayname(userQuery.get("Playname").toString());
        user.setAvatar(userQuery.get("AvatarId").toString());
        return user;
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
