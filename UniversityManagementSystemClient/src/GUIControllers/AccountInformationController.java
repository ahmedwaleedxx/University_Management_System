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
public class AccountInformationController {

    AccountInformation gui;
    Registry r;
    AdminInterface admin;
    EmployeeInterface employee;

    public AccountInformationController(AccountInformation gui, Registry r, AdminInterface admin) throws RemoteException {
        this.gui = gui;
        this.r = r;
        this.employee =(EmployeeInterface) admin;


        
        gui.getIdlbl().setText(String.valueOf(employee.getEmployeeID()));
        gui.getNamelbl().setText(employee.getEmployeeFName() + " "+ employee.getEmployeeLName());
        gui.getEmaillbl().setText(employee.getEmail());
        gui.getPasswordlbl().setText(employee.getPassword());
        gui.getSalarylbl().setText(String.valueOf(employee.getEmployeeSalary()));
        gui.getBanklbl().setText(employee.getEmployeeBankAccountIBAN());
        
        gui.getjButton1().setOpaque(false);     
        
        gui.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try{
                AdminMenu am = new AdminMenu();
                        am.setLocationRelativeTo(null);
                        am.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        AdminMenuController amc = new AdminMenuController(am, r, admin);
                        gui.dispose();
              } catch (RemoteException ex) {
                    Logger.getLogger(AccountInformationController.class.getName()).log(Level.SEVERE, null, ex);
                }
              
              }
        });
        
        
    }
    
    
}
