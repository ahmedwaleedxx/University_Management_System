package GUIControllers;


import GUIControllers.StudentHomeController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import rmi.StudentDTO;
import universitymanagementsystemclient.GUIs.StudentHome;
import universitymanagementsystemclient.GUIs.StudentView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author infolos
 */
public class ViewStudentController {
    StudentView sd;
    Registry reg;
    StudentDTO stud;

    public ViewStudentController(StudentView sd, Registry reg, StudentDTO stud) {
        this.sd = sd;
        this.reg = reg;
        this.stud = stud;
        
        sd.getPassword().setText(stud.getPassword());
        sd.getEmail().setText(stud.getEmail());
        sd.getFname().setText(stud.getStudentFName());
        sd.getLname().setText(stud.getStudentLName());
        sd.getPass().addActionListener(new PassChange());
        sd.getCancel().addActionListener(new Cancel());
    }
    
    class Cancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentHome guii = new StudentHome();
            guii.setVisible(true);
            sd.setVisible(false);
            StudentHomeController newCont = new StudentHomeController(guii,reg,stud);
            
        }
    }
    
    class PassChange implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
        
        
    }
    
}
