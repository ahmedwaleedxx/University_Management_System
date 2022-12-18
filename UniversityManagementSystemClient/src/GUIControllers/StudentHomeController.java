package GUIControllers;

import rmi.StudentDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import universitymanagementsystemclient.GUIs.Courses;
import universitymanagementsystemclient.GUIs.StudentHome;
import universitymanagementsystemclient.GUIs.StudentView;
import universitymanagementsystemclient.GUIs.Transcript;

/**
 *
 * @author infolos
 */
public class StudentHomeController {
    
    StudentHome gui;
    Registry reg;
    StudentDTO stud;

    public StudentHomeController(StudentHome gui, Registry reg, StudentDTO stud) {
        this.gui = gui;
        this.reg = reg;
        this.stud = stud;
        
        gui.getStudName().setText(stud.getStudentFName());
        
        if(stud.isIsGraduated() == false){
            gui.getStudStatus().setText("Undergrad");
        }else{
            gui.getStudStatus().setText("Grad");
        }
        if(stud.isPaidTutionFees() == false){
            gui.getFeesLab().setText("Paid :D");
        }else{
            gui.getFeesLab().setText("Not yet!!");
        }
        gui.getLogout().addActionListener(new LogoutAction());
        gui.getCourses().addActionListener(new CoursesAction());
        gui.getTranscript().addActionListener(new Transcripts());
        gui.getView().addActionListener(new View());
    }

    class View implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           StudentView vs = new StudentView();
           vs.setVisible(true);
           gui.dispose();
           ViewStudentController vc = new ViewStudentController(vs,reg,stud);
           
        }
        
    }
    class LogoutAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
        }
    }
    
    class CoursesAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Courses cour = new Courses();
            cour.setVisible(true);
            gui.setVisible(false);
            CoursesController coursesController = new CoursesController(cour,reg,stud);
        }
        
    }
    
    class Transcripts implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Transcript tran = new Transcript();
            tran.setVisible(true);
            gui.setVisible(false);
            TranscriptController trcont = new TranscriptController(tran,reg,stud);
        }
        
    }

    
    
    
}
