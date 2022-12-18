/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ManageFacultiesController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ManageFacultiesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        });
            
            
            gui.getAddfacbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                
                try {
                    SuperiorAdminInterface admin = (SuperiorAdminInterface) r.lookup("superiorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String name = gui.getNametb().getText();
                    String dean = gui.getDeantb().getText();
                    String email = gui.getEmailtb().getText();
                    double fees = Double.parseDouble( gui.getFeestb().getText());
                  
                                                   //4,"Ahmed","Waleed", "ahmed", "1234", 100, null, "CIB", "Doctor", null, null
                    admin.AddFaculty(id, name, dean, email, fees);
                    JOptionPane.showMessageDialog(gui, "Faculty Inserted Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageFacultiesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                
           
            }
            

           
        });
            
              gui.getUpdatefacbtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         try {
                    SuperiorAdminInterface admin = (SuperiorAdminInterface) r.lookup("superiorinterface");
                     int id = Integer.parseInt(gui.getIdtb().getText());
                    String name = gui.getNametb().getText();
                    String dean = gui.getDeantb().getText();
                    String email = gui.getEmailtb().getText();
                    double fees = Double.parseDouble( gui.getFeestb().getText());
                    
                    admin.UpdateFaculty(id, name, dean, email, fees);
                    JOptionPane.showMessageDialog(gui, "Faculty Updated Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageFacultiesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                });
                                  
                                  
               gui.getDeletefacbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                  try {
                    SuperiorAdminInterface admin = (SuperiorAdminInterface) r.lookup("superiorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    admin.RemoveFaculty(id);
                    JOptionPane.showMessageDialog(gui, "Faculty Deleted Successfully");
                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageFacultiesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
               
               
               gui.getFactbl().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
          
                 DefaultTableModel defaulttablemodelmodel = (DefaultTableModel) gui.getFactbl().getModel();
                int index = gui.getFactbl().getSelectedRow();

                gui.getIdtb().setText(defaulttablemodelmodel.getValueAt(index, 0).toString());
                gui.getNametb().setText(defaulttablemodelmodel.getValueAt(index, 1).toString());
                gui.getDeantb().setText(defaulttablemodelmodel.getValueAt(index, 2).toString());
                gui.getEmailtb().setText(defaulttablemodelmodel.getValueAt(index, 3).toString());
                gui.getFeestb().setText(defaulttablemodelmodel.getValueAt(index, 4).toString());

            }

            @Override
            public void mousePressed(MouseEvent e) {
              }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
