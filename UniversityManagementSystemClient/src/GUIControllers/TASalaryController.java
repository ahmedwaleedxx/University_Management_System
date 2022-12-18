/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rmi.EmployeeInterface;
import rmi.FinanceInterface;
import universitymanagementsystemclient.GUIs.DoctorSalary;
import universitymanagementsystemclient.GUIs.FinanceSelection;

import universitymanagementsystemclient.GUIs.TASalary;

/**
 *
 * @author farouuk
 */
public class TASalaryController {
     Registry r;
    TASalary gui;
    FinanceInterface finance;
    EmployeeInterface employee;
    
    
     public TASalaryController(FinanceInterface finance, TASalary gui, Registry r) throws RemoteException{
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
            gui.getTas().setModel(model);
             EmployeeInterface emp;
            for (int i = 0; i < financee.getTAs().size(); i++) {
                emp = (EmployeeInterface) financee.getTAs().get(i);
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
         
         
          gui.getBackbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                FinanceSelection fs = new FinanceSelection();
                        fs.setLocationRelativeTo(null);
                        fs.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        FinanceSelectionController amc = new FinanceSelectionController(fs, finance, r);
                        gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(AdminSalaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
        });
          
           gui.getUpdatesalarybtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   try {
                    FinanceInterface admin = (FinanceInterface) r.lookup("financeinterface");
                    int id = Integer.parseInt(gui.getIdtxt().getText());
                    double salary = Double.parseDouble(gui.getSalarytxt().getText());
                    
                    admin.setTASalary(id, salary);
                    JOptionPane.showMessageDialog(gui, "Doctor Salary Updated Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageAdminsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                });
     }
}
