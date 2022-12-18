/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import rmi.Student;
import rmi.StudentDTO;
import rmi.StudentInterface;
import universitymanagementsystemclient.GUIs.Notifications;

/**
 *
 * @author ahmedwaleed
 */
public class NotificationsController {
    
    Notifications gui;
    Registry r;
    Student student;

    public NotificationsController(Notifications gui, Registry r, Student student) throws RemoteException {
        this.gui = gui;
        this.r = r;
        this.student = student;
        
        ArrayList<String> notifications= student.getNotificationsByFacultyName(student.getFaculty());
        
        String noti = "";
        for(int i = 0; i< notifications.size() ; i++){
            noti +=notifications.get(i)+"\n ";
        }
        gui.getNotificationsta().setText(noti);
        
       // gui.getNotificationsta().setText(notifications.toString());
        gui.getNotificationsta().setEditable(false);
        
    }
    
    
    
}
