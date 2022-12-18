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
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rmi.AdminInterface;
import rmi.DoctorInterface;
import rmi.EmployeeInterface;
import rmi.MaterialInterface;
import rmi.Student;
import rmi.SuperiorAdminInterface;
import rmi.user;
import universitymanagementsystemclient.GUIs.*;

/**
 *
 * @author ahmedwaleed
 */
public class DoctorMaterialsController {

    DoctorMaterials gui;
    Registry r;
    //DoctorInterface doctor;
    EmployeeInterface employee;

    DoctorMaterialsController(DoctorMaterials gui, DoctorInterface doctor, Registry r) throws RemoteException {
        this.gui = gui;
        this.r = r;
        this.employee = (EmployeeInterface) doctor;

        gui.getIdlbl().setText(employee.getEmployeeFName());
        gui.getShowbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    
                    System.out.println("Line 1");
                    DoctorInterface doctor = (DoctorInterface) r.lookup("doctorinterface");
                    System.out.println("Line 2");
                    DefaultTableModel model = new DefaultTableModel();
                    System.out.println("Line 3");
                    model.setColumnCount(0);
                    System.out.println("Line 4");
                    String header[] = new String[]{"ID", "Title", "Visibility", "CourseID"};
                    System.out.println("Line 5");
                    model.setColumnIdentifiers(header);
                    System.out.println("Line 6");
                    gui.getDocstable().setModel(model);
                    System.out.println("Line 7");
                    MaterialInterface std;
                    System.out.println("Line 8");
                    int doctoridd=employee.getEmployeeID();
                    System.out.println(doctor.getMaterialbyDoctorID(doctoridd));
                    System.out.println("Line 9");
                    for (int i = 0; i < doctor.getMaterialbyDoctorID(1).size(); i++) {
                        
                        //String id = stud.getCoursesID().get(i);
                        std = (MaterialInterface) doctor.getMaterialbyDoctorID(doctoridd).get(i);
                        int id = std.getID();
                        String title = std.getMaterialTitle();
                        boolean vis = std.isMaterialVisibility();
                        int cid = std.getCourseID();

                        model.addRow(new Object[]{id, title, vis, cid});
                    }

                } catch (RemoteException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ManageStudentsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        
        gui.getAddbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 try {
                    DoctorInterface doctor = (DoctorInterface) r.lookup("doctorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String title = gui.getTitletb().getText();
                    boolean visibility = Boolean.parseBoolean( gui.getViisibilitytb().getText());
                    int courseid = Integer.parseInt(gui.getCourseidtb().getText());
                                                   //4,"Ahmed","Waleed", "ahmed", "1234", 100, null, "CIB", "Doctor", null, null
                   
                    JOptionPane.showMessageDialog(gui, "Doctor Inserted Successfully");

                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(ManageDoctorsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        gui.getUpdatebtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                DoctorInterface doctor = (DoctorInterface) r.lookup("doctorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    String title = gui.getTitletb().getText();
                    boolean visibility = Boolean.parseBoolean( gui.getViisibilitytb().getText());
                    int courseid = Integer.parseInt(gui.getCourseidtb().getText());
                    
                    doctor.UpdateMaterialTitle(id, title);
                    doctor.UpdateMaterialVisibility(id, visibility);
                    doctor.UpdateMaterialCourse(id, courseid);
                    
               } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(DoctorMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
            }
        });
        gui.getDeletebtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
   try {
                    DoctorInterface doctor = (DoctorInterface) r.lookup("doctorinterface");
                    int id = Integer.parseInt(gui.getIdtb().getText());
                    doctor.RemoveCourseMaterial(id);
                    JOptionPane.showMessageDialog(gui, "Doctor Deleted Successfully");
                } catch (RemoteException ex) {
                    Logger.getLogger(ManageDoctorsController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ManageDoctorsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
        gui.getDocstable().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                              DefaultTableModel defaulttablemodelmodel = (DefaultTableModel) gui.getDocstable().getModel();
                int index = gui.getDocstable().getSelectedRow();

                gui.getIdtb().setText(defaulttablemodelmodel.getValueAt(index, 0).toString());
                gui.getTitletb().setText(defaulttablemodelmodel.getValueAt(index, 1).toString());
                gui.getViisibilitytb().setText(defaulttablemodelmodel.getValueAt(index, 2).toString());
                gui.getCourseidtb().setText(defaulttablemodelmodel.getValueAt(index, 3).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
          }

            @Override
            public void mouseReleased(MouseEvent e) {
             }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
           }
        });

    }

}
