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

/**
 *
 * @author firstx
 */
public class FormRegister extends javax.swing.JFrame {
    
    String avatarId;
    Database db;
    UserDao userdao;
    RegisterService registerservice;
    User user;
    
    public FormRegister() {
        initComponents();
        avatarId = "Default.png";
        userdao = new UserDao();
        registerservice = new RegisterService();
    }
    
    public void submitRegister() {
        
        userdao.addUser(txtUsername.getText(), txtPassword.getText(), txtPlayerName.getText(), avatarId);
        
        masregisterSuccess();
        gotoLogin();
    }
    
    public void masregisterSuccess() {
        JLabel label = new JLabel("สมัครสมาชิกสำเร็จ!");
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this, label);
        
    }

    /*
    แสดงข้อความเตือนเมื่อผู้ใช้ กรองข้อมูลไม่ครบถ้วน
     */
    public void masIsNotFillAllFiled() {
        JLabel label = new JLabel("“กรุณากรอกข้อมูลให้ครบถ้วน");
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    /*
    แสดงข้อความเตือนเมื่อ ชื่อผู้ใช้ ที่ผู้ใช้กรอกมา ซ้ำกับ ชื่อผู้ใช้ในระบบ
     */
    public void masUserExist() {
        JLabel label = new JLabel("ชื่อผู้ใช้นี้มีอยู่แล้วในระบบ");
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    /*
    แสดงข้อความเตือนเมื่อผู้ใช้ยืนยันรหัสผ่านไม่ถูกต้อง
     */
    public void masPassDoNotMatch() {
        JLabel label = new JLabel("รหัสผ่านไม่ตรงกัน");
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    /*
    แสดงข้อความเตือนเมื่อผู้ใช้ กรอก ชื่อผู้ใช้ หรือ รหัสผ่าน ไม่ตรงกับเงื่อนไข
     */
    public void masUserPassLessThan8() {
        JLabel label = new JLabel("รหัสผ่านต้องมีความยาวมากกว่า หรือเท่ากับ 8 ตัวอักษร");
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
    }
    
    public void masUsernameLessThan8() {
        JLabel label = new JLabel("ชื่อผู้ใช้งานต้องมีความยาวมากกว่า หรือเท่ากับ 8 ตัวอักษร และไม่ซ้ำกันกับในระบบ");
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    /*

    
     /*
    ตรวจสอบว่าผู้ใช้ยืนยันรหัสผ่านถูกต้องหรือไม่
    โดยข้อมูลเข้าเป็น String
    และข้อมูลออกเป็น Boolean
     */
    public boolean isPasswordMatching(String txtPass, String txtRePass) {//isPasswordMatching  checkrepass
        if (txtPass.equals(txtRePass)) {
//            System.out.println("ซ้ำ");
            return true;
        } else {
            return false;
        }
    }

    /*
     ตรวจสอบว่า ผู้ใช้กรอก ชื่อผู้ใช้ และ รหัสผ่าน ตรงตามเงื่อนไขของระบบหรือไม่
     True = ตรงตามเงื่อนไข
     Flase = ไม่ตรงตามเงื่อนไข
     */
    public boolean checkLengthIdPass(String txtUsername, String txtPassword) {
        if (txtPassword.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }
    
   public boolean checkLengthIdUsername(String txtUsername, String txtPassword) {
        if (txtUsername.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }
    
    public void pushRegister() {
        
        if (!isFillAllFiled(txtUsername.getText(), txtPlayerName.getText(), txtPassword.getText(), txtConfirmPassword.getText())) {
            masIsNotFillAllFiled();
            clearInpurField();
            
        } else {
            if (checkLengthIdPass(txtUsername.getText(), txtPassword.getText())) {
                
                if (isPasswordMatching(txtPassword.getText(), txtConfirmPassword.getText())) { // รหัสผ่านตรงกัน

                    if (registerservice.checkUserExist(txtUsername.getText())) {
                        masUserExist();
                        clearInpurField();
                    } else {
                        
                        submitRegister();
                        clearInpurField();
                        
                    }
                } else {
                    masPassDoNotMatch();
                    clearInpurField();
                }
                
            } else {
                masUserPassLessThan8();
                clearInpurField();
            }
            
        }
    }

    /*
    ไปยังหน้า Login
     */
    public void gotoLogin() {
        dispose();
        new FormLogin().show();
        
    }

    /*
    ตรวจสอบว่า ผู้ใช้กรอกข้อมูลครบถ้วนหรือไม่
    True = ไม่ครบถ้วน
    False = ครบถ้วน
     */
    public boolean isFillAllFiled(String txtUsername, String txtPlayerName, String txtPassword, String txtConfirmPassword) { //isFillAllFiled  checkEmpty

        if (txtUsername.equals("") || txtPlayerName.equals("") || txtPassword.equals("") || txtConfirmPassword.equals("")) {
            return false; // Text ว่าง
        } else {
            return true; // Text โดนกรอกแล้ว
        }
        
    }

    /*
    ล้างช่องกรอกข้อมูลทั้งหมด
     */
    public void clearInpurField() {
        txtPlayerName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        //tx_avatar.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        imgAvatarShow = new javax.swing.JLabel();
        btnAvatar3 = new javax.swing.JButton();
        btnAvatar1 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnAvatar2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPlayerName = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel1.setText("Username :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("TH Sarabun New", 1, 48)); // NOI18N
        jLabel6.setText("REGISTER");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        imgAvatarShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/AvatarDefault.png"))); // NOI18N
        jPanel1.add(imgAvatarShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 110, 110));

        btnAvatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Avatar3.png"))); // NOI18N
        btnAvatar3.setBorder(null);
        btnAvatar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        btnAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Avatar1.png"))); // NOI18N
        btnAvatar1.setBorder(null);
        btnAvatar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        txtPassword.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 240, -1));

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel4.setText("ConfirmPassword :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        txtConfirmPassword.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 240, -1));

        btnAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Avatar2.png"))); // NOI18N
        btnAvatar2.setBorder(null);
        btnAvatar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 110, 100));

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel2.setText("Password :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel3.setText("Player's Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        txtUsername.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 240, -1));

        txtPlayerName.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jPanel1.add(txtPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 240, -1));

        btnRegister.setText("Sign in");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        jButton2.setText("Clear");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvatar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar3ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon(FormLogin.class.getResource("/image/Avatar3.png"));
        imgAvatarShow.setIcon(icon);
        avatarId = "Avatar3.png";
        System.out.println(avatarId);
    }//GEN-LAST:event_btnAvatar3ActionPerformed

    private void btnAvatar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar1ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon(FormLogin.class.getResource("/image/Avatar1.png"));
        imgAvatarShow.setIcon(icon);
        avatarId = "Avatar1.png";
        System.out.println(avatarId);

    }//GEN-LAST:event_btnAvatar1ActionPerformed

    private void btnAvatar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar2ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon(FormLogin.class.getResource("/image/Avatar2.png"));
        imgAvatarShow.setIcon(icon);
        avatarId = "Avatar2.png";
        System.out.println(avatarId);
    }//GEN-LAST:event_btnAvatar2ActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        pushRegister();
        

    }//GEN-LAST:event_btnRegisterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvatar1;
    private javax.swing.JButton btnAvatar2;
    private javax.swing.JButton btnAvatar3;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel imgAvatarShow;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPlayerName;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
