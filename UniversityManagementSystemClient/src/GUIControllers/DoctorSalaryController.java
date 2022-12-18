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
import rmi.DoctorInterface;
import rmi.EmployeeInterface;
import rmi.FinanceInterface;
import rmi.Student;
import rmi.SuperiorAdminInterface;
import universitymanagementsystemclient.GUIs.DoctorSalary;
import universitymanagementsystemclient.GUIs.FinanceSelection;

/**
 *
 * @author farouuk
 */
public class DoctorSalaryController {
    Registry r;
    DoctorSalary gui;
    FinanceInterface finance;
    EmployeeInterface employee;
    
    public DoctorSalaryController(FinanceInterface finance, DoctorSalary gui, Registry r) throws RemoteException{
        this.r = r;
        this.gui = gui;
        this.employee=(EmployeeInterface)finance;
        gui.getTestlbl().setText(employee.getEmployeeFName());

        
        
        
        
        
         try {
             FinanceInterface financee = (FinanceInterface) r.lookup("financeinterface");
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(0);
            String header[] = new String[]{"ID", "First Name", "Last Name", "Salary"};
            model.setColumnIdentifiers(header);
            gui.getDoctors().setModel(model);
             EmployeeInterface emp;
            for (int i = 0; i < financee.getDoctors().size(); i++) {
                emp = (EmployeeInterface) financee.getDoctors().get(i);
                int id = emp.getEmployeeID();
                String fname = emp.getEmployeeFName();
                String lname = emp.getEmployeeLName();
                double salary = emp.getEmployeeSalary();

                model.addRow(new Object[]{id, fname, lname, salary});
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
  
    
    
}
