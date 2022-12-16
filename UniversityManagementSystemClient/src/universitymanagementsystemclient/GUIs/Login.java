/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystemclient.GUIs;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ahmedwaleed
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    public JRadioButton getAdminrb() {
        return adminrb;
    }

    public ButtonGroup getButtonGroup2() {
        return buttonGroup2;
    }

    public JButton getCancelbtn() {
        return cancelbtn;
    }

    public JRadioButton getDoctorrb() {
        return doctorrb;
    }

    public JLabel getEmailerrlbl() {
        return emailerrlbl;
    }

    public JTextField getEmailtb() {
        return emailtb;
    }

    public JPanel getErrorpnl() {
        return errorpnl;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JButton getLoginbtn() {
        return loginbtn;
    }

    public JLabel getPassworderrlbl() {
        return passworderrlbl;
    }

    public JPasswordField getPasswordtb() {
        return passwordtb;
    }

    public JCheckBox getShowpasswordcb() {
        return showpasswordcb;
    }

    public JButton getSignupbtn() {
        return signupbtn;
    }

    public JRadioButton getStudentrb() {
        return studentrb;
    }

    public JRadioButton getTarb() {
        return tarb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        emailtb = new javax.swing.JTextField();
        passwordtb = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        signupbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        showpasswordcb = new javax.swing.JCheckBox();
        loginbtn = new javax.swing.JButton();
        studentrb = new javax.swing.JRadioButton();
        doctorrb = new javax.swing.JRadioButton();
        tarb = new javax.swing.JRadioButton();
        adminrb = new javax.swing.JRadioButton();
        errorpnl = new javax.swing.JPanel();
        emailerrlbl = new javax.swing.JLabel();
        passworderrlbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailtb.setBackground(new java.awt.Color(255, 255, 255));
        emailtb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        emailtb.setForeground(new java.awt.Color(153, 153, 153));
        emailtb.setText("Enter Username");
        jPanel1.add(emailtb, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 192, 307, 42));

        passwordtb.setBackground(new java.awt.Color(255, 255, 255));
        passwordtb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        passwordtb.setForeground(new java.awt.Color(153, 153, 153));
        passwordtb.setText("Enter Password");
        jPanel1.add(passwordtb, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 270, 307, 42));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("E-mail :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 192, 158, 42));

        jLabel3.setFont(new java.awt.Font("Engravers MT", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 221, 68));

        signupbtn.setBackground(new java.awt.Color(0, 0, 0));
        signupbtn.setFont(new java.awt.Font("Engravers MT", 0, 18)); // NOI18N
        signupbtn.setForeground(new java.awt.Color(255, 255, 255));
        signupbtn.setText("Signup");
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });
        jPanel1.add(signupbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 466, 130, 30));

        cancelbtn.setBackground(new java.awt.Color(0, 0, 0));
        cancelbtn.setFont(new java.awt.Font("Engravers MT", 0, 18)); // NOI18N
        cancelbtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelbtn.setText("Cancel");
        jPanel1.add(cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 466, 130, 30));

        jLabel5.setFont(new java.awt.Font("Engravers MT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 269, 158, 42));

        showpasswordcb.setBackground(new java.awt.Color(0, 0, 0));
        showpasswordcb.setFont(new java.awt.Font("Engravers MT", 0, 11)); // NOI18N
        showpasswordcb.setForeground(new java.awt.Color(255, 255, 255));
        showpasswordcb.setText("     Show Password");
        showpasswordcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordcbActionPerformed(evt);
            }
        });
        jPanel1.add(showpasswordcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 310, 180, -1));

        loginbtn.setBackground(new java.awt.Color(0, 0, 0));
        loginbtn.setFont(new java.awt.Font("Engravers MT", 0, 18)); // NOI18N
        loginbtn.setForeground(new java.awt.Color(255, 255, 255));
        loginbtn.setText("Login ");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 170, 46));

        buttonGroup2.add(studentrb);
        studentrb.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        studentrb.setForeground(new java.awt.Color(255, 255, 255));
        studentrb.setText("Student");
        jPanel1.add(studentrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        buttonGroup2.add(doctorrb);
        doctorrb.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        doctorrb.setForeground(new java.awt.Color(255, 255, 255));
        doctorrb.setText("Doctor");
        jPanel1.add(doctorrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        buttonGroup2.add(tarb);
        tarb.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        tarb.setForeground(new java.awt.Color(255, 255, 255));
        tarb.setText("TA");
        jPanel1.add(tarb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        buttonGroup2.add(adminrb);
        adminrb.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        adminrb.setForeground(new java.awt.Color(255, 255, 255));
        adminrb.setText("Admin");
        jPanel1.add(adminrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        javax.swing.GroupLayout errorpnlLayout = new javax.swing.GroupLayout(errorpnl);
        errorpnl.setLayout(errorpnlLayout);
        errorpnlLayout.setHorizontalGroup(
            errorpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        errorpnlLayout.setVerticalGroup(
            errorpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jPanel1.add(errorpnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 230));

        emailerrlbl.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(emailerrlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 200, 30));

        passworderrlbl.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(passworderrlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 200, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grad2.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showpasswordcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordcbActionPerformed

    }//GEN-LAST:event_showpasswordcbActionPerformed

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signupbtnActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed

    }//GEN-LAST:event_loginbtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminrb;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JRadioButton doctorrb;
    private javax.swing.JLabel emailerrlbl;
    private javax.swing.JTextField emailtb;
    private javax.swing.JPanel errorpnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginbtn;
    private javax.swing.JLabel passworderrlbl;
    private javax.swing.JPasswordField passwordtb;
    private javax.swing.JCheckBox showpasswordcb;
    private javax.swing.JButton signupbtn;
    private javax.swing.JRadioButton studentrb;
    private javax.swing.JRadioButton tarb;
    // End of variables declaration//GEN-END:variables
}
