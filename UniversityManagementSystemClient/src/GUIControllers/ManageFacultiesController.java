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
import javax.swing.table.DefaultTableModel;
import rmi.EmployeeInterface;
import rmi.FacultyInterface;
import rmi.SuperiorAdminInterface;
import universitymanagementsystemclient.GUIs.ManageFaculties;
import universitymanagementsystemclient.GUIs.SuperiorAdminMenu;

/**
 *
 * @author ahmedwaleed
 */
public class ManageFacultiesController {

    ManageFaculties gui;
    Registry r;
    SuperiorAdminInterface admin;
    EmployeeInterface employee;

    public ManageFacultiesController(ManageFaculties gui, Registry r, SuperiorAdminInterface admin) {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) admin;
        
        
        try {
             SuperiorAdminInterface superior = (SuperiorAdminInterface) r.lookup("superiorinterface");
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(0);
            String header[] = new String[]{"ID", "Name", "Dean Name", "Email", "Fees"};
            model.setColumnIdentifiers(header);
            gui.getFactbl().setModel(model);
             FacultyInterface fac;
            for (int i = 0; i < superior.getFaculties().size(); i++) {          
                
                fac = (FacultyInterface) superior.getFaculties().get(i);
                int id = fac.getFacultyID();
                String name = fac.getName();
                String dean = fac.getDeanName();
                String email = fac.getMail();
                double fees = fac.getFees();



                model.addRow(new Object[]{id, name, dean, email, fees});
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
