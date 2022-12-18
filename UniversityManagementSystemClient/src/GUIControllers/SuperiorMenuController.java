/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.AdminInterface;
import rmi.EmployeeInterface;
import rmi.SuperiorAdminInterface;
import universitymanagementsystemclient.GUIs.*;

/**
 *
 * @author ahmedwaleed
 */
public class SuperiorMenuController {

    SuperiorAdminMenu gui;
    Registry r;
    SuperiorAdminInterface admin;
    EmployeeInterface employee;

    public SuperiorMenuController(SuperiorAdminMenu gui, Registry r, SuperiorAdminInterface admin) {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) admin;

        gui.getMngdoctorsbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageDoctors l = new ManageDoctors();
                    l.setLocationRelativeTo(null);
                    l.setVisible(true);
                    Registry r1;
                    r1 = LocateRegistry.getRegistry(1099);
                    ManageDoctorsController gui_controller = new ManageDoctorsController(l, r1, admin);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        gui.getMngTAsbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageTAs l = new ManageTAs();
                    l.setLocationRelativeTo(null);
                    l.setVisible(true);
                    Registry r1;
                    r1 = LocateRegistry.getRegistry(1099);
                    ManageTAsController gui_controller = new ManageTAsController(l, r1, admin);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        gui.getMngfacbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageFaculties l = new ManageFaculties();
                    l.setLocationRelativeTo(null);
                    l.setVisible(true);
                    Registry r1;
                    r1 = LocateRegistry.getRegistry(1099);
                    ManageFacultiesController gui_controller = new ManageFacultiesController(l, r1, admin);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        gui.getMngcoursebtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageCourses l = new ManageCourses();
                    l.setLocationRelativeTo(null);
                    l.setVisible(true);
                    Registry r1;
                    r1 = LocateRegistry.getRegistry(1099);
                    ManageCoursesController gui_controller = new ManageCoursesController(l, r1, admin);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        gui.getMngadminbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageAdmins l = new ManageAdmins();
                    l.setLocationRelativeTo(null);
                    l.setVisible(true);
                    Registry r1;
                    r1 = LocateRegistry.getRegistry(1099);
                    ManageAdminsController gui_controller = new ManageAdminsController(l, r1, admin);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        gui.getAccinfobtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SuperiorAccountInfo ai = new SuperiorAccountInfo();
                    ai.setLocationRelativeTo(null); // This makes the window appears centered
                    ai.setVisible(true); // This shows the gui

                    Registry r;
                    r = LocateRegistry.getRegistry(1099);

                    SuperiorAccountInfoController gui_controller = new SuperiorAccountInfoController(ai, admin, r);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        gui.getSignoutbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Login l = new Login();
                    l.setLocationRelativeTo(null);
                    l.setVisible(true);
                    Registry r1;
                    r1 = LocateRegistry.getRegistry(1099);
                    LoginController gui_controller = new LoginController(l, r1);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
