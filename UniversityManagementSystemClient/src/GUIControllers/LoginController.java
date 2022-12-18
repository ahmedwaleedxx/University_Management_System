/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import java.awt.Color;
import universitymanagementsystemclient.GUIs.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import rmi.AdminInterface;
import rmi.DoctorInterface;
import rmi.FinanceInterface;
import rmi.Student;
import rmi.StudentDTO;
import rmi.SuperiorAdminInterface;
import rmi.user;

/**
 *
 * @author ahmedwaleed
 */
public class LoginController {

    static Login gui;
    Registry r;
    
    
    
    Color placeholdercolor = new Color(153, 153, 153);
    Color txtColor = new Color(51, 51, 51);
    ImageIcon erroricon = new ImageIcon("src/Images/erroricon.png");

    public LoginController(Login gui, Registry r) {
        this.gui = gui;
        this.r = r;
        gui.getPasswordtb().setEchoChar((char)0);
        gui.getShowpasswordcb().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPassword();
            }
        });
        gui.getLoginbtn().addActionListener(new getLoginbtn());
        gui.getCancelbtn().addActionListener(new getCancelbtn());

        gui.getEmailtb().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (gui.getEmailtb().getText().equals("Enter Username")) {
                    gui.getEmailtb().setText("");
                    gui.getEmailtb().setForeground(txtColor);
                    gui.getEmailerrlbl().setText("");
                    gui.getEmailerrlbl().setIcon(null);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (gui.getEmailtb().getText().equals("")) {
                    gui.getEmailtb().setText("Enter Username");
                    gui.getEmailtb().setForeground(placeholdercolor);
                    gui.getEmailerrlbl().setText("Missing Field!!!");
                    gui.getEmailerrlbl().setIcon(erroricon);
                }
            }
        });

        gui.getPasswordtb().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (gui.getPasswordtb().getText().equals("Enter Password")) {
                    gui.getPasswordtb().setText("");
                    gui.getPasswordtb().setForeground(txtColor);
                    gui.getPasswordtb().setEchoChar('*');
                    gui.getPassworderrlbl().setText("");
                    gui.getPassworderrlbl().setIcon(null);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (gui.getPasswordtb().getText().equals("")) {
                    gui.getPasswordtb().setText("Enter Password");
                    gui.getPasswordtb().setForeground(placeholdercolor);
                    gui.getPasswordtb().setEchoChar((char) 0);
                    gui.getPassworderrlbl().setText("Missing Field!!!");
                    gui.getPassworderrlbl().setIcon(erroricon);
                }
            }
        });
        makeTransparent();
    }

    public void showPassword() {
        if (gui.getShowpasswordcb().isSelected()) {
            gui.getPasswordtb().setEchoChar((char) 0);
        } else if (!(gui.getPasswordtb().getText().equals("Enter Password"))) {
            gui.getPasswordtb().setEchoChar('*');
        }
    }

    public void makeTransparent() {
        gui.getErrorpnl().setVisible(false);
        gui.getAdminrb().setOpaque(false);
        gui.getStudentrb().setOpaque(false);
        gui.getDoctorrb().setOpaque(false);
        gui.getTarb().setOpaque(false);
        gui.getSuperioradminrb().setOpaque(false);
        gui.getFinancerb().setOpaque(false);
        gui.getLoginbtn().setOpaque(false);
        gui.getCancelbtn().setOpaque(false);
        gui.getSignupbtn().setOpaque(false);
        gui.getShowpasswordcb().setOpaque(false);
    }

    public void validateLogin() {

        if (gui.getEmailtb().getText().isEmpty() && gui.getPasswordtb().getText().isEmpty()) {
            gui.getEmailerrlbl().setIcon(erroricon);
            gui.getEmailerrlbl().setText("  Missing Field !!");
            gui.getPassworderrlbl().setIcon(erroricon);
            gui.getPassworderrlbl().setText("  Missing Field !!");
        } else if (gui.getEmailtb().getText().isEmpty()) {
            gui.getEmailerrlbl().setIcon(erroricon);
            gui.getEmailerrlbl().setText("  Missing Field !!");
        } else if (gui.getPasswordtb().getText().isEmpty()) {
            gui.getPassworderrlbl().setIcon(erroricon);
            gui.getPassworderrlbl().setText("  Missing Field !!");
        }

    }

    private static class getCancelbtn implements ActionListener {

        public getCancelbtn() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
        }
    }

    class getLoginbtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            userlogin();

        }

        public void userlogin() {
            try {
                String email = gui.getEmailtb().getText();
                String password = gui.getPasswordtb().getText();
                String usertype = null;
                validateLogin();

                
                if (gui.getAdminrb().isSelected()) {
                    usertype = "Admin";
                    user admin = (user) r.lookup("admin");
                    AdminInterface admin2 = (AdminInterface) admin.Login(email, password, usertype);
                    if (admin2 == null) {
                        JOptionPane.showMessageDialog(null, "Login Failed!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Logged in Successfully !!");
                        
                        AdminMenu am = new AdminMenu();
                        am.setLocationRelativeTo(null);
                        am.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        AdminMenuController amc = new AdminMenuController(am, r, admin2);
                        gui.dispose();
                    }

                } else if(gui.getSuperioradminrb().isSelected()){
                            usertype="Superior Admin";
                            user superior = (user) r.lookup("superior");
                            SuperiorAdminInterface sai = (SuperiorAdminInterface) superior.Login(email, password, usertype);
                            if(sai == null){
                                JOptionPane.showMessageDialog(null, "Login Failed!!");
                            }else{
                                JOptionPane.showMessageDialog(null, "Logged in Successfully");
                                
                                SuperiorAdminMenu am = new SuperiorAdminMenu();
                        am.setLocationRelativeTo(null);
                        am.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        SuperiorMenuController amc = new SuperiorMenuController(am, r, sai);
                        gui.dispose();
                            }
                            }
                    
                    
                 else if (gui.getStudentrb().isSelected()) {
                    usertype = "Student";
                    user student = (user) r.lookup("student");
                    Student student2 = (Student) student.Login(email, password, usertype);

                    if (student2 == null) {
                        JOptionPane.showMessageDialog(null, "Login Failed!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Logged in Successfully !!");
                        
                        StudentHome hom = new StudentHome();
                            hom.setLocationRelativeTo(null);
                            hom.setVisible(true);
                            
                            Registry reg = LocateRegistry.getRegistry(1099);
// int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty, ArrayList<String> CoursesID
                            
                            ArrayList<String> cours = new ArrayList<>();
                            cours.add("1");
                            StudentDTO std = new StudentDTO(1,"Hi","Lo","Test@test.com","2", (float) 1.2,false,true,"SE","ICS",cours);
                            StudentHomeController con = new StudentHomeController(hom,reg,std);
                        
                    }
                } else if (gui.getTarb().isSelected()) {
                    usertype = "TA";
                    user ta = (user) r.lookup("ta");
                    user ta2 = ta.Login(email, password, usertype);

                    if (ta2 == null) {
                        JOptionPane.showMessageDialog(null, "Login Failed!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Logged in Successfully !!");
                    }

                } else if (gui.getDoctorrb().isSelected()) {
                    usertype = "Doctor";
                    user doctor = (user) r.lookup("doctor");
                    DoctorInterface doctor2 = (DoctorInterface) doctor.Login(email, password, usertype);
                    if (doctor2 == null) {
                        JOptionPane.showMessageDialog(null, "Login Failed!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Logged in Successfully !!");
                         DoctorMaterials dm = new DoctorMaterials();
                        dm.setLocationRelativeTo(null);
                        dm.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        DoctorMaterialsController amc = new DoctorMaterialsController(dm, doctor2, r);
                        gui.dispose();
                        
                    }

                }else if(gui.getFinancerb().isSelected()){
                usertype = "Finance";
                    user finance = (user) r.lookup("finance");
                    FinanceInterface finance2 = (FinanceInterface) finance.Login(email, password, usertype);
                    if (finance2 == null) {
                        JOptionPane.showMessageDialog(null, "Login Failed!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Logged in Successfully !!");
                        
                        FinanceSelection fs = new FinanceSelection();
                        fs.setLocationRelativeTo(null);
                        fs.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        FinanceSelectionController amc = new FinanceSelectionController(fs, finance2, r);
                        gui.dispose();
                        
                        
                    }
                }
                    else {
                    gui.getErrorpnl().setVisible(true);
                    gui.getErrorpnl().setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Please choose user type to login !!", "Invalid User Type", 0, erroricon);
                }

                //


            } catch (RemoteException | NotBoundException ex) {
                System.out.println(ex);
            }

            // gui.dispose();
        }
    }

}
