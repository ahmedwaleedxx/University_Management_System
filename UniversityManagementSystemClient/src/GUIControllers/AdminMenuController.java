/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import static GUIControllers.LoginController.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.AdminInterface;
import rmi.EmployeeInterface;
import universitymanagementsystemclient.GUIs.*;

/**
 *
 * @author ahmedwaleed
 */
public class AdminMenuController {

    AdminMenu gui;
    Registry r;
    AdminInterface admin;
    EmployeeInterface employee;

    public AdminMenuController(AdminMenu gui, Registry r, AdminInterface admin) throws RemoteException {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) admin;

        gui.getManagestudentsbtn().setOpaque(false);
        gui.getAccinfobtn().setOpaque(false);
        gui.getSignoutbtn().setOpaque(false);     
        
        
        gui.getjLabel1().setText("Welcome " + employee.getEmployeeFName());

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

                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        gui.getManagestudentsbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageStudents ms = new ManageStudents();
                    ms.setLocationRelativeTo(null); // This makes the window appears centered
                    ms.setVisible(true); // This shows the gui

                    Registry r;
                    r = LocateRegistry.getRegistry(1099);

                    ManageStudentsController gui_controller = new ManageStudentsController(ms, r, admin);
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
                    AccountInformation ai = new AccountInformation();
                    ai.setLocationRelativeTo(null); // This makes the window appears centered
                    ai.setVisible(true); // This shows the gui

                    Registry r;
                    r = LocateRegistry.getRegistry(1099);

                    AccountInformationController gui_controller = new AccountInformationController(ai, r, admin);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
