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
public interface SuperiorAdminInterface extends Remote {

    public void AssignDoctor(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType ) throws RemoteException;

    public void UpdateDoctorInfo(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException;

    public void RemoveDoctor(int id) throws RemoteException;

    public void AssignTA(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException;

    public void UpdateTAInfo(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException;

    public void RemoveTA(int id) throws RemoteException;

    public void AddFaculty(int FacultyID, String Name, String DeanName, String Mail, double Fees) throws RemoteException;

    public void UpdateFaculty(int FacultyID, String Name, String DeanName, String Mail, double Fees) throws RemoteException;

    public void RemoveFaculty(int id) throws RemoteException;

    public void AddCourse(int CourseID, String CourseTitle, int CourseDoctor, String Mail, String Faculty) throws RemoteException;

    public void UpdateCourse(int CourseID, String CourseTitle, int CourseDoctor, String Mail, String Faculty) throws RemoteException;

    public void DeleteCourse(int id) throws RemoteException;

    public void AddAdmin(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException;

    public void UpdateAdmin(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException;

    public ArrayList<EmployeeInterface> getDoctors() throws RemoteException;
    
    public ArrayList<EmployeeInterface> getTAs() throws RemoteException;
     
     public ArrayList<EmployeeInterface> getAdmins() throws RemoteException;
     
     public ArrayList<FacultyInterface> getFaculties() throws RemoteException;
     
      public ArrayList<CourseInterface> getCourses() throws RemoteException;
}
