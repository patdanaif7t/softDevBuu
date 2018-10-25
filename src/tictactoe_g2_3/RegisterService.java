/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_g2_3;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;
import static tictactoe_g2_3.Database.findAll;
import static tictactoe_g2_3.Database.getCollection;

/**
 *
 * @author firstx
 */
public class RegisterService {

    private static Database db;

    public RegisterService() {
        db = new Database();
    }

    public boolean checkUserExist(String User) {//checkUserExist  checkID
        db.setCollection("user");
        try {
            Document myDoc = db.find("Username", User);
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
            return false;
        } else {
            return true;
        }

    }
    public void alertMessageIcon(String message) {
        ImageIcon icon = new ImageIcon(FormLogin.class.getResource("/image/correct.png"));
        JLabel text = new JLabel(message);
        text.setFont(new Font("TH Sarabun New", Font.BOLD, 25));
        JOptionPane.showMessageDialog(
                null,
                text, "เข้าสู่ระบบ", JOptionPane.INFORMATION_MESSAGE,
                icon);
    }
    
    public void alertMessage(String message) {
        JLabel label = new JLabel(message);
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    public boolean isFieldAllFilled(String username,
            String playerName,
            String password,
            String confirmPassword) {
        if (isFill(username)
                && isFill(playerName)
                && isFill(password)
                && isFill(confirmPassword)) {
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
