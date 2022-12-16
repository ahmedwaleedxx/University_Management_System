/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystemclient.GUIs;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ahmedwaleed
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudents
     */
    public ManageStudents() {
        initComponents();
    }

    public JButton getjButton1() {
        return deletestudentbtn;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JTable getStudentstbl() {
        return studentstbl;
    }

    public JButton getAddstudentbtn() {
        return addstudentbtn;
    }

    public JButton getBackbtn() {
        return backbtn;
    }

    public JButton getDeletestudentbtn() {
        return deletestudentbtn;
    }

    public JTextField getEmailtb() {
        return emailtb;
    }

    public JTextField getFacultytb() {
        return facultytb;
    }

    public JTextField getFnametb() {
        return fnametb;
    }

    public JTextField getGradetb() {
        return gradetb;
    }

    public JTextField getGraduatedtb() {
        return graduatedtb;
    }

    public JTextField getIdtb() {
        return idtb;
    }

    public JTextField getLnametb() {
        return lnametb;
    }

    public JTextField getMajortb() {
        return majortb;
    }

    public JTextField getPaidfeestb() {
        return paidfeestb;
    }

    public JTextField getPasswordtb() {
        return passwordtb;
    }

    public JButton getUpdatestudentbtn() {
        return updatestudentbtn;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentstbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deletestudentbtn = new javax.swing.JButton();
        idtb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailtb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        graduatedtb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fnametb = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordtb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        paidfeestb = new javax.swing.JTextField();
        majortb = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lnametb = new javax.swing.JTextField();
        gradetb = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        facultytb = new javax.swing.JTextField();
        addstudentbtn = new javax.swing.JButton();
        updatestudentbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentstbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(studentstbl);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 88, 876, 155));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Students");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 9, 521, 61));

        deletestudentbtn.setBackground(new java.awt.Color(0, 0, 0));
        deletestudentbtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        deletestudentbtn.setForeground(new java.awt.Color(255, 255, 255));
        deletestudentbtn.setText("Delete Student");
        getContentPane().add(deletestudentbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, -1, -1));

        idtb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(idtb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 130, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 70, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("E-mail");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 70, 30));

        emailtb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(emailtb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 130, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Graduated");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 80, 30));

        graduatedtb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(graduatedtb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 130, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 90, 30));

        fnametb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(fnametb, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 130, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 90, 30));

        passwordtb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(passwordtb, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 130, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Paid Fees");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 90, 30));

        paidfeestb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(paidfeestb, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 130, 30));

        majortb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(majortb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 130, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Major");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 100, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Grade");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 100, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Last Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 100, 30));

        lnametb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(lnametb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 130, 30));

        gradetb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(gradetb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 130, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Faculty");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 70, 30));

        facultytb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(facultytb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 130, 30));

        addstudentbtn.setBackground(new java.awt.Color(0, 0, 0));
        addstudentbtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        addstudentbtn.setForeground(new java.awt.Color(255, 255, 255));
        addstudentbtn.setText("Add Student");
        getContentPane().add(addstudentbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, -1, -1));

        updatestudentbtn.setBackground(new java.awt.Color(0, 0, 0));
        updatestudentbtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        updatestudentbtn.setForeground(new java.awt.Color(255, 255, 255));
        updatestudentbtn.setText("Update Student");
        getContentPane().add(updatestudentbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, -1, -1));

        backbtn.setBackground(new java.awt.Color(0, 0, 0));
        backbtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("Back to menu");
        getContentPane().add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 160, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grad2.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addstudentbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton deletestudentbtn;
    private javax.swing.JTextField emailtb;
    private javax.swing.JTextField facultytb;
    private javax.swing.JTextField fnametb;
    private javax.swing.JTextField gradetb;
    private javax.swing.JTextField graduatedtb;
    private javax.swing.JTextField idtb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lnametb;
    private javax.swing.JTextField majortb;
    private javax.swing.JTextField paidfeestb;
    private javax.swing.JTextField passwordtb;
    private javax.swing.JTable studentstbl;
    private javax.swing.JButton updatestudentbtn;
    // End of variables declaration//GEN-END:variables
}
