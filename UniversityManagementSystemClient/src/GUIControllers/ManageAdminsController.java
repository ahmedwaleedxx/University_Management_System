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
import rmi.SuperiorAdminInterface;
import universitymanagementsystemclient.GUIs.ManageAdmins;
import universitymanagementsystemclient.GUIs.SuperiorAdminMenu;

/**
 *
 * @author ahmedwaleed
 */

public class ManageAdminsController {
    ManageAdmins gui;
    Registry r;
    SuperiorAdminInterface admin;
    EmployeeInterface employee;

    public ManageAdminsController(ManageAdmins gui, Registry r, SuperiorAdminInterface admin) {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) admin;
        
        
          try {
             SuperiorAdminInterface superior = (SuperiorAdminInterface) r.lookup("superiorinterface");
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(0);
            String header[] = new String[]{"ID", "First Name", "Last Name", "Email", "Password", "Salary", "Bank"};
            model.setColumnIdentifiers(header);
            gui.getAdminstbl().setModel(model);
             EmployeeInterface emp;
            for (int i = 0; i < superior.getAdmins().size(); i++) {
                emp = (EmployeeInterface) superior.getAdmins().get(i);
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
 
    
         
         
         gui.getAddadminbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                
                try {
                    SuperiorAdminInterface admin = (SuperiorAdminInterface) r.lookup("superiorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String fname = gui.getFnametb().getText();
                    String lname = gui.getLnametb().getText();
                    String email = gui.getEmailtb().getText();
                    String password = gui.getPasswordtb().getText();
                    float salary = Float.parseFloat(gui.getSalarytb().getText());
                    String bank = gui.getBanktb().getText();
                                                   //4,"Ahmed","Waleed", "ahmed", "1234", 100, null, "CIB", "Doctor", null, null
                    admin.AddAdmin(id, fname, lname, email, password, salary, null, bank, "Admin");
                    JOptionPane.showMessageDialog(gui, "Admin Inserted Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                
           
            }
            

           
        });
                                  gui.getUpdateadminbtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         try {
                    SuperiorAdminInterface admin = (SuperiorAdminInterface) r.lookup("superiorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String fname = gui.getFnametb().getText();
                    String lname = gui.getLnametb().getText();
                    String email = gui.getEmailtb().getText();
                    String password = gui.getPasswordtb().getText();
                    float salary = Float.parseFloat(gui.getSalarytb().getText());
                    String bank = gui.getBanktb().getText();
                    
                    admin.UpdateAdmin(id, fname, lname, email, password, salary, null, bank, "Admin");
                    JOptionPane.showMessageDialog(gui, "Admin Updated Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                });
        
        
                                      gui.getBackbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           try{
                SuperiorAdminMenu am = new SuperiorAdminMenu();
                        am.setLocationRelativeTo(null);
                        am.setVisible(true);
                        Registry r = LocateRegistry.getRegistry(1099);
                        SuperiorMenuController amc = new SuperiorMenuController(am, r, admin);
                        gui.dispose();
           }    catch (RemoteException ex) {
                    Logger.getLogger(ManageDoctorsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        });
    }
    
    
}
