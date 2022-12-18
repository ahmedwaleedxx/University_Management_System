/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author ahmedwaleed
 */
public interface CourseInterface extends Remote{

    public void AddCourseTA(int courseid, int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, int courseID) throws RemoteException;

    public void RemoveCourseTA(int courseid) throws RemoteException;

    public void UpdateCourseTitle(int courseid, String title) throws RemoteException;

    public void DeleteCourse(int id) throws RemoteException;
    
     public int getCourseID() throws RemoteException;

    public String getCourseTitle() throws RemoteException;

    public int getCourseDoctor() throws RemoteException;

    public String getMail() throws RemoteException;

    public String getFaculty() throws RemoteException;
}
