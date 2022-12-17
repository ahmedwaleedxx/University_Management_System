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
import universitymanagementsystemclient.GUIs.AdminMenu;
import universitymanagementsystemclient.GUIs.ManageStudents;

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

        gui.getjLabel1().setText("Welcome "+employee.getEmployeeFName());

        gui.getjButton1().addActionListener(new ActionListener() {
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
    }

}
