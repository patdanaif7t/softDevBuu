/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_g2_3;

import static com.mongodb.client.model.Filters.eq;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author firstx
 */
public class LobbyService {

    private static Database db;

    public LobbyService() {
        db = new Database();
        db.setCollection("Lobby");
    }

    public boolean isFull(int countRoom) {
        if (countRoom >= 2) {
            return true;
        } else {
            return false;
        }
    }
    
   
    
    public void alertMessage(String message) {
        JLabel label = new JLabel(message);
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
    }

   public int getCountRoom(int id) {
        
       db.setCollection("Lobby");

        Document count = db.find("ID", id);
        return count.getInteger("CountPlayer");

    }

    
}


