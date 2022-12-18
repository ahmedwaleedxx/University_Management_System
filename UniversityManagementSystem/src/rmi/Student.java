/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import universitymanagementsystem.Course;
import universitymanagementsystem.Observer;

/**
 *
 * @author ahmedwaleed
 */
public interface Student extends Remote {

    //public Student data(int id, String fname, String lname, String mail, String password, ) throws RemoteException;
   
    public int getStudentID() throws RemoteException;

    public String getStudentFName() throws RemoteException;

    public String getStudentLName() throws RemoteException;

    public String getEmail() throws RemoteException;

    public String getPassword() throws RemoteException;

    public float getStudentOverAllGrade() throws RemoteException;

    public boolean isIsGraduated() throws RemoteException;

    public boolean isPaidTutionFees() throws RemoteException;

    public String getMajor() throws RemoteException;

    public String getFaculty() throws RemoteException;
    
   //  public ArrayList<String> getNotificationsByFacultyName(String FacultyName)throws RemoteException;
     
     public ArrayList<String> getCoursessByFacultyName(String FacultyName) throws RemoteException;

    // public ArrayList<Observer> getObservers() throws RemoteException;
}
