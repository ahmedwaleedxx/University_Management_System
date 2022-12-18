/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIControllers;

import rmi.StudentDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.bson.Document;
import universitymanagementsystemclient.GUIs.Courses;
import universitymanagementsystemclient.GUIs.StudentHome;

/**
 *
 * @author infolos
 */
public class CoursesController {
    
    Courses gui;
    Registry reg;
    StudentDTO stud;
    MongoCollection<Document> collection;
    
    public void fillCourses(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        String header[] = new String[] { "CourseID", "Name"};
        model.setColumnIdentifiers(header);
        gui.getCourTable().setModel(model);
        for(int i = 0; i < stud.getCoursesID().size(); i++){
            model.addRow(new Object[] {stud.getCoursesID().get(i)});
        }
            
    }
        
    public CoursesController(Courses gui, Registry reg, StudentDTO stud) {
            this.gui = gui;
            this.reg = reg;
            this.stud = stud;
            gui.getCancel().addActionListener(new Cancel());
            if(stud.isPaidTutionFees() == true){
                fillCourses();
            }
    }
    

    
    class Cancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentHome guii = new StudentHome();
            guii.setVisible(true);
            gui.setVisible(false);
            StudentHomeController newCont = new StudentHomeController(guii,reg,stud);
            
        }
        
    }
    
    
    
    
}
