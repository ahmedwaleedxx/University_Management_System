package GUIControllers;


import rmi.StudentDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.Student;
import universitymanagementsystemclient.GUIs.StudentHome;
import universitymanagementsystemclient.GUIs.Transcript;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author infolos
 */
public class TranscriptController {
    
    Transcript gui;
    Registry reg;
    StudentDTO user;

    public TranscriptController(Transcript gui, Registry reg, StudentDTO user) {
        this.gui = gui;
        this.reg = reg;
        this.user = user;
        
        gui.getCancel().addActionListener(new Cancel());
        String grade = "" + user.getStudentOverAllGrade();
        gui.getGrade().setText(grade);
        
    }
    
    class Cancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                StudentHome guii = new StudentHome();
                guii.setVisible(true);
                gui.setVisible(false);
                StudentHomeController newCont = new StudentHomeController(guii,reg, (Student) user);
            } catch (RemoteException ex) {
                Logger.getLogger(TranscriptController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
