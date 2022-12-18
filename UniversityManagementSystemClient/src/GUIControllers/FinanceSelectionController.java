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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rmi.DoctorInterface;
import rmi.EmployeeInterface;
import rmi.FinanceInterface;

import rmi.Student;
import universitymanagementsystemclient.GUIs.DoctorSalary;
import universitymanagementsystemclient.GUIs.FinanceSelection;

/**
 *
 * @author farouuk
 */
public class FinanceSelectionController {

    Registry r;
    FinanceSelection gui;
    FinanceInterface finance;
    EmployeeInterface employee;

    public FinanceSelectionController(FinanceSelection gui, FinanceInterface finance, Registry r) throws RemoteException {
        this.r = r;
        this.gui = gui;
        this.employee = (EmployeeInterface) finance;

        gui.getNamelbl().setText(employee.getEmployeeFName());
        gui.getDoctorbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DoctorSalary fs = new DoctorSalary();
                fs.setLocationRelativeTo(null);
                fs.setVisible(true);
                try {

                    Registry r;

                    r = LocateRegistry.getRegistry(1099);
                    DoctorSalaryController gui_controller = new DoctorSalaryController(finance, fs, r);
                    gui.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(FinanceSelectionController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

}
