/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_g2_3;

/**
 *
 * @author firstx
 */
public class User {
    String username;
    String password;
    String playname;
    String avatar;

    public User(String username, String password, String playname, String avatar) {
        this.username = username;
        this.password = password;
        this.playname = playname;
        this.avatar = avatar;
    }
    
    public User() {
        
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlayname(String playname) {
        this.playname = playname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPlayname() {
        return playname;
    }

    public String getAvatar() {
        return avatar;
    }
    
    
}
