/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rmi.AdminInterface;
import rmi.EmployeeInterface;
import rmi.Student;
import rmi.user;
import universitymanagementsystemclient.GUIs.*;

/**
 *
 * @author ahmedwaleed
 */
public class ManageStudentsController {

    ManageStudents gui;
    Registry r;
    Registry r1;
    AdminInterface adminn;
    EmployeeInterface employee;
    
    public ManageStudentsController(ManageStudents gui, Registry r, AdminInterface adminn) throws RemoteException {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) adminn;
        System.out.println("Hello");

        gui.getjLabel13().setText(employee.getEmployeeFName());
        try {
            AdminInterface admin = (AdminInterface) r.lookup("admininterface");
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(0);
            String header[] = new String[]{"StudentID", "First Name", "Last Name", "Email", "Password", "Grade", "Graduated", "Paid", "Major", "Faculty"};
            model.setColumnIdentifiers(header);
            gui.getStudentstbl().setModel(model);
            Student std;
            for (int i = 0; i < admin.getStudents().size(); i++) {
                //String id = stud.getCoursesID().get(i);
                std = (Student) admin.getStudents().get(i);
                int id = std.getStudentID();
                String fname = std.getStudentFName();
                String lname = std.getStudentLName();
                String email = std.getEmail();
                String password = std.getPassword();
                float grade = std.getStudentOverAllGrade();
                boolean isgraduated = std.isIsGraduated();
                boolean ispaidfees = std.isPaidTutionFees();
                String major = std.getMajor();
                String faculty = std.getFaculty();

                model.addRow(new Object[]{id, fname, lname, email, password, grade, isgraduated, ispaidfees, major, faculty});
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        gui.getUpdatestudentbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AdminInterface admin = (AdminInterface) r.lookup("admininterface");

                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String fname = gui.getFnametb().getText();
                    String lname = gui.getLnametb().getText();
                    String email = gui.getEmailtb().getText();
                    String password = gui.getPasswordtb().getText();
                    float grade = Float.parseFloat(gui.getGradetb().getText());
                    boolean isgrad = Boolean.parseBoolean(gui.getGradetb().getText());
                    boolean ispaid = Boolean.parseBoolean(gui.getPaidfeestb().getText());
                    String major = gui.getMajortb().getText();
                    String faculty = gui.getFacultytb().getText();

                    admin.UpdateStudent(id, fname, lname, email, password, grade, isgrad, ispaid, major, faculty);

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        gui.getDeletestudentbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    AdminInterface admin = (AdminInterface) r.lookup("admininterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    admin.DeleteStudent(id);
                } catch (RemoteException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        gui.getAddstudentbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    AdminInterface admin = (AdminInterface) r.lookup("admininterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String fname = gui.getFnametb().getText();
                    String lname = gui.getLnametb().getText();
                    String email = gui.getEmailtb().getText();
                    String password = gui.getPasswordtb().getText();
                    float grade = Float.parseFloat(gui.getGradetb().getText());
                    boolean isgrad = Boolean.parseBoolean(gui.getGradetb().getText());
                    boolean ispaid = Boolean.parseBoolean(gui.getPaidfeestb().getText());
                    String major = gui.getMajortb().getText();
                    String faculty = gui.getFacultytb().getText();
                    admin.RegisterStudent(id, fname, lname, email, password, grade, isgrad, ispaid, major, faculty);
                    JOptionPane.showMessageDialog(gui, "Student Inserted Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        gui.getBackbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  try{
                AdminMenu am = new AdminMenu();
                        am.setLocationRelativeTo(null);
                        am.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        AdminMenuController amc = new AdminMenuController(am, r, adminn);
                        gui.dispose();
              } catch (RemoteException ex) {
                    Logger.getLogger(AccountInformationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
              
        });

        gui.getStudentstbl().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel defaulttablemodelmodel = (DefaultTableModel) gui.getStudentstbl().getModel();
                int index = gui.getStudentstbl().getSelectedRow();

                gui.getIdtb().setText(defaulttablemodelmodel.getValueAt(index, 0).toString());
                gui.getFnametb().setText(defaulttablemodelmodel.getValueAt(index, 1).toString());
                gui.getLnametb().setText(defaulttablemodelmodel.getValueAt(index, 2).toString());
                gui.getEmailtb().setText(defaulttablemodelmodel.getValueAt(index, 3).toString());
                gui.getPasswordtb().setText(defaulttablemodelmodel.getValueAt(index, 4).toString());
                gui.getGradetb().setText(defaulttablemodelmodel.getValueAt(index, 5).toString());
                gui.getGraduatedtb().setText(defaulttablemodelmodel.getValueAt(index, 6).toString());
                gui.getPaidfeestb().setText(defaulttablemodelmodel.getValueAt(index, 7).toString());
                gui.getMajortb().setText(defaulttablemodelmodel.getValueAt(index, 8).toString());
                gui.getFacultytb().setText(defaulttablemodelmodel.getValueAt(index, 9).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

//   
}
