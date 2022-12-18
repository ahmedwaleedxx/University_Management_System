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
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rmi.AdminInterface;
import rmi.DoctorInterface;
import rmi.EmployeeInterface;
import rmi.MaterialInterface;
import rmi.Student;
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
                    DoctorInterface doctor = (DoctorInterface) r.lookup("doctorinterface");
                    
                    DefaultTableModel model = new DefaultTableModel();
                    model.setColumnCount(0);
                    String header[] = new String[]{"ID", "Title", "Visibility", "CourseID"};
                    model.setColumnIdentifiers(header);
                    gui.getDocstable().setModel(model);
                    MaterialInterface std;
                    System.out.println(doctor.getMaterialbyDoctorID(employee.getEmployeeID()));
                    for (int i = 0; i < doctor.getMaterialbyDoctorID(employee.getEmployeeID()).size(); i++) {
                        
                        //String id = stud.getCoursesID().get(i);
                        std = (MaterialInterface) doctor.getMaterialbyDoctorID(employee.getEmployeeID()).get(i);
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

    }

}
