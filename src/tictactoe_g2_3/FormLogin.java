package tictactoe_g2_3;

public class FormLogin extends javax.swing.JFrame {

    LoginService service;

    public FormLogin() {
        initComponents();
        service = new LoginService();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        usrLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        loginHeader = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 219, 34));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 221, 36));

        usrLabel.setFont(new java.awt.Font("TH Sarabun New", 1, 30)); // NOI18N
        usrLabel.setText("Username :");
        jPanel1.add(usrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

        passLabel.setFont(new java.awt.Font("TH Sarabun New", 1, 30)); // NOI18N
        passLabel.setText("Password :");
        jPanel1.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        btnRegister.setFont(new java.awt.Font("TH Sarabun New", 3, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(0, 102, 255));
        btnRegister.setText("here");
        btnRegister.setActionCommand("Register");
        btnRegister.setBorder(null);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 283, 30, 20));

        loginHeader.setFont(new java.awt.Font("TH Sarabun New", 1, 48)); // NOI18N
        loginHeader.setText("LOGIN");
        jPanel1.add(loginHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel3.setText("Don't have any account ? click");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        btnSignIn.setText("Login");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, -1, -1));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        gotoRegister();

    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        if (service.isFieldAllField(txtUsername.getText(), txtPassword.getText())) {
            if (service.checkUser(txtUsername.getText(), txtPassword.getText())) {
                service.welcomeMessage(service.getPlayerName());
                gotoLobby();
            } else {
                service.alertMessage("กรุณาตรวจสอบชื่อผู้ใช้งานและรหัสผ่านให้ถูกต้อง");
                clearText();
            }
        } else {
            service.alertMessage("กรุณากรอกข้อมูลให้ครบถ้วน");
            clearText();
            
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
       dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public void clearText() {
        txtUsername.setText("");
        txtPassword.setText("");
    }
    
    public void gotoRegister() {
        new FormRegister().show();
        dispose();
    }

    public void gotoLobby() {
        new FormLobby().show();
        dispose();
    }

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginHeader;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel usrLabel;
    // End of variables declaration//GEN-END:variables
}
