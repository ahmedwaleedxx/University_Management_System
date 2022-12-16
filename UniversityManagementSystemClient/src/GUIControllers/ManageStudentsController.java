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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rmi.AdminInterface;
import rmi.Student;
import universitymanagementsystemclient.GUIs.ManageStudents;

/**
 *
 * @author ahmedwaleed
 */
public class ManageStudentsController {

    ManageStudents gui;
    Registry r;

    public ManageStudentsController(ManageStudents gui, Registry r) {
        this.gui = gui;
        this.r = r;
        System.out.println("Hello");
        getStudentsInTable();

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

    public void getStudentsInTable() {
        try {
            AdminInterface admin = (AdminInterface) r.lookup("admininterface");
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(0);
            String header[] = new String[]{"StudentID", "First Name", "Last Name", "Email", "Password", "Grade", "Graduated", "Major", "Faculty"};
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
    }

}
