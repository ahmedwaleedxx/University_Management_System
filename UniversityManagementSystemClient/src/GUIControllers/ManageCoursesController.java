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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rmi.CourseInterface;
import rmi.EmployeeInterface;
import rmi.FacultyInterface;
import rmi.SuperiorAdminInterface;
import universitymanagementsystemclient.GUIs.ManageCourses;
import universitymanagementsystemclient.GUIs.SuperiorAdminMenu;

/**
 *
 * @author ahmedwaleed
 */
public class ManageCoursesController {

    ManageCourses gui;
    Registry r;
    SuperiorAdminInterface admin;
    EmployeeInterface employee;

    public ManageCoursesController(ManageCourses gui, Registry r, SuperiorAdminInterface admin) {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) admin;

        gui.getBackbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SuperiorAdminMenu am = new SuperiorAdminMenu();
                    am.setLocationRelativeTo(null);
                    am.setVisible(true);
                    Registry r = LocateRegistry.getRegistry(1099);
                    SuperiorMenuController amc = new SuperiorMenuController(am, r, admin);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(ManageCoursesController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        try {
            SuperiorAdminInterface superior = (SuperiorAdminInterface) r.lookup("superiorinterface");
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(0);
            String header[] = new String[]{"ID", "Title", "Doctor ID", "Email", "Faculty"};
            model.setColumnIdentifiers(header);
            gui.getCoursestbl().setModel(model);
            CourseInterface course;
            for (int i = 0; i < superior.getCourses().size(); i++) {

                course = (CourseInterface) superior.getCourses().get(i);
                int id = course.getCourseID();
                String name = course.getCourseTitle();
                int doctorid = course.getCourseDoctor();
                String email = course.getMail();
                String faculty = course.getFaculty();

                model.addRow(new Object[]{id, name, doctorid, email, faculty});
            }

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ManageCoursesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        gui.getAddcoursebtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    SuperiorAdminInterface admin = (SuperiorAdminInterface) r.lookup("superiorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String title = gui.getTitletb().getText();
                    int doctorid = Integer.parseInt(gui.getDocidtb().getText());
                    String email = gui.getEmailtb().getText();
                    String faculty = gui.getFacultytb().getText();

                    //4,"Ahmed","Waleed", "ahmed", "1234", 100, null, "CIB", "Doctor", null, null
                    admin.AddCourse(id, title, doctorid, email, faculty);
                    JOptionPane.showMessageDialog(gui, "Course Inserted Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageCoursesController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        gui.getUpdatecoursebtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SuperiorAdminInterface admin = (SuperiorAdminInterface) r.lookup("superiorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String title = gui.getTitletb().getText();
                    int doctorid = Integer.parseInt(gui.getDocidtb().getText());
                    String email = gui.getEmailtb().getText();
                    String faculty = gui.getFacultytb().getText();

                    admin.UpdateCourse(id, title, doctorid, email, faculty);
                    JOptionPane.showMessageDialog(gui, "Course Updated Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageCoursesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        gui.getDeletecoursebtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    SuperiorAdminInterface admin = (SuperiorAdminInterface) r.lookup("superiorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    admin.DeleteCourse(id);
                    JOptionPane.showMessageDialog(gui, "Course Deleted Successfully");
                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageCoursesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        gui.getCoursestbl().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                DefaultTableModel defaulttablemodelmodel = (DefaultTableModel) gui.getCoursestbl().getModel();
                int index = gui.getCoursestbl().getSelectedRow();

                gui.getIdtb().setText(defaulttablemodelmodel.getValueAt(index, 0).toString());
                gui.getTitletb().setText(defaulttablemodelmodel.getValueAt(index, 1).toString());
                gui.getDocidtb().setText(defaulttablemodelmodel.getValueAt(index, 2).toString());
                gui.getEmailtb().setText(defaulttablemodelmodel.getValueAt(index, 3).toString());
                gui.getFacultytb().setText(defaulttablemodelmodel.getValueAt(index, 4).toString());

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

}
