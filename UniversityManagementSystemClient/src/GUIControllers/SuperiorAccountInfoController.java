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
import rmi.EmployeeInterface;
import rmi.SuperiorAdminInterface;
import universitymanagementsystemclient.GUIs.AdminMenu;
import universitymanagementsystemclient.GUIs.SuperiorAccountInfo;
import universitymanagementsystemclient.GUIs.SuperiorAdminMenu;

/**
 *
 * @author ahmedwaleed
 */
public class SuperiorAccountInfoController {

    Registry r;
    SuperiorAdminInterface admin;
    EmployeeInterface employee;
    SuperiorAccountInfo gui = new SuperiorAccountInfo();

    public SuperiorAccountInfoController(SuperiorAccountInfo gui, SuperiorAdminInterface admin, Registry r) throws RemoteException {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface)admin;
    
        gui.getIdlbl().setText(String.valueOf(employee.getEmployeeID()));
        gui.getNamelbl().setText(employee.getEmployeeFName() + " "+ employee.getEmployeeLName());
        gui.getEmaillbl().setText(employee.getEmail());
        gui.getPasswordlbl().setText(employee.getPassword());
        gui.getSalarylbl().setText(String.valueOf(employee.getEmployeeSalary()));
        gui.getBanklbl().setText(employee.getEmployeeBankAccountIBAN());
       
        
       gui.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try{
                     SuperiorAdminMenu am = new SuperiorAdminMenu();
                        am.setLocationRelativeTo(null);
                        am.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        SuperiorMenuController amc = new SuperiorMenuController(am, r, admin);
                        gui.dispose();
              } catch (RemoteException ex) {
                    Logger.getLogger(AccountInformationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    
}
