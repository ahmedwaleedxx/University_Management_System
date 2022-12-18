/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rmi.AdminInterface;
import rmi.EmployeeInterface;
import rmi.Student;
import rmi.SuperiorAdminInterface;
import universitymanagementsystemclient.GUIs.*;

/**
 *
 * @author ahmedwaleed
 */
public class ManageDoctorsController {
    ManageDoctors gui;
    Registry r;
    SuperiorAdminInterface admin;
    EmployeeInterface employee;

    public ManageDoctorsController(ManageDoctors gui, Registry r, SuperiorAdminInterface admin) {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) admin;
        
        
         try {
             SuperiorAdminInterface superior = (SuperiorAdminInterface) r.lookup("superiorinterface");
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(0);
            String header[] = new String[]{"ID", "First Name", "Last Name", "Email", "Password", "Salary", "Bank"};
            model.setColumnIdentifiers(header);
            gui.getDoctorstbl().setModel(model);
             EmployeeInterface emp;
            for (int i = 0; i < superior.getDoctors().size(); i++) {
                emp = (EmployeeInterface) superior.getDoctors().get(i);
                int id = emp.getEmployeeID();
                String fname = emp.getEmployeeFName();
                String lname = emp.getEmployeeLName();
                String email = emp.getEmail();
                String password = emp.getPassword();
                double salary = emp.getEmployeeSalary();
                String bank = emp.getEmployeeBankAccountIBAN();


                model.addRow(new Object[]{id, fname, lname, email, password, salary, bank});
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
