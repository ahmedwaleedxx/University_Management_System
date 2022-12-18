/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.Student;
import rmi.StudentDTO;
import universitymanagementsystemclient.GUIs.ChangePass;
import universitymanagementsystemclient.GUIs.StudentHome;

/**
 *
 * @author infolos
 */
public class ChangePassController {
    
    ChangePass gui;
    StudentDTO stud;
    Registry reg;

    public ChangePassController(ChangePass guii, StudentDTO stud, Registry reg) {
        this.gui = guii;
        this.stud = stud;
        this.reg = reg;
        
        
        gui.getCancel().addActionListener(new Cancel());
        gui.getUpdate().addActionListener(new Update());
        
    }
    
     class Cancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                StudentHome guii = new StudentHome();
                guii.setVisible(true);
                gui.setVisible(false);     
                StudentHomeController newCont = new StudentHomeController(guii,reg, (Student) stud);
            } catch (RemoteException ex) {
                Logger.getLogger(ChangePassController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
     class Update implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(gui.getCurPass().getText() == ""){
                gui.getcurFil().setText("Current pass mustn't be empty");
            }else if(gui.getNewPass().getText() == ""){
                gui.getnewFil().setText("New pass mustn't be empty");
            }else{
                if(gui.getCurPass().getText() == stud.getPassword()){
                    stud.setPassword(gui.getNewPass().getText());
                }else{
                    gui.getError().setText("Current Password is inccorect");
                }
            }
        }
         
         
     }
    
}
