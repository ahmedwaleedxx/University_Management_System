/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import Student.Student;
import java.rmi.RemoteException;
import universitymanagementsystem.DBConnect;

/**
 *
 * @author infolos
 */
public class StudentMapper {
    
    private DBConnect db;
        
    public void insert(Student s) throws RemoteException{
        db.SignUpStudent(s);    
    }
    
    public void update(Student s) throws RemoteException{
        db.UpdateStudent(s);
    }
    
    public void delete(Student s) throws RemoteException{
        db.DeleteStudent(s);
    }
    
}
