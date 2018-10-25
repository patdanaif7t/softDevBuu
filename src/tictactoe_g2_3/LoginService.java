/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_g2_3;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author firstx
 */
public class LoginService {

    UserDao userDao;
    String playerName = "";

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public LoginService() {
        userDao = new UserDao();
    }

    public void welcomeMessage(String Playname) {
        ImageIcon icon = new ImageIcon(FormLogin.class.getResource("/image/correct.png"));
        JLabel text = new JLabel("ยินดีต้อนรับ " + Playname);
        text.setFont(new Font("TH Sarabun New", Font.BOLD, 25));
        JOptionPane.showMessageDialog(
                null,
                text, "เข้าสู่ระบบ", JOptionPane.INFORMATION_MESSAGE,
                icon);
    }

    public void alertMessage(String message) {
        ImageIcon icon = new ImageIcon(FormLogin.class.getResource("/image/Warning_sign.png"));
        JLabel text = new JLabel(message);
        text.setFont(new Font("TH Sarabun New", Font.BOLD, 25));
        JOptionPane.showMessageDialog(
                null,
                text, "เข้าสู่ระบบ", JOptionPane.INFORMATION_MESSAGE,
                icon);
    }

    public boolean checkUser(String username,
            String password) {
        try {
            User user = userDao.getUser(username);
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                setPlayerName(user.getPlayname().toString());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
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

    public boolean isFieldAllField(String username,
            String password) {
        if (isFill(username)
                && isFill(password)) {
            return true;
        } else {
            return false;
        }
    }

}
