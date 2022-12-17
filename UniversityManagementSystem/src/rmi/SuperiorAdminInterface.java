/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import Doctor.Doctor;
import TA.TA;
import java.rmi.*;
import java.util.ArrayList;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public interface SuperiorAdminInterface extends Remote {

    public void AssignDoctor(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, Course AssignedCourse, TA AssignedTA)throws RemoteException;

    public void UpdateDoctorInfo(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, Course AssignedCourse, TA AssignedTA) throws RemoteException;

    public void RemoveDoctor(int id) throws RemoteException;

    public void AssignTA(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, Course AssignedCourse, TA AssignedTA) throws RemoteException;

    public void UpdateTAInfo(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, Course AssignedCourse, TA AssignedTA) throws RemoteException;

    public void RemoveTA(int id) throws RemoteException;
    
    

    public void AddFaculty(int FacultyID, String Name, String DeanName, String Mail, ArrayList<Doctor> doctors) throws RemoteException;

    public void UpdateFaculty(int FacultyID, String Name, String DeanName, String Mail, ArrayList<Doctor> doctors) throws RemoteException;

    public void RemoveFaculty(int id) throws RemoteException;

    public void AddCourse(int CourseID, String CourseTitle, Doctor CourseDoctor, String Mail, String Faculty) throws RemoteException;

    public void UpdateCourse(int CourseID, String CourseTitle, Doctor CourseDoctor, String Mail, String Faculty) throws RemoteException;

    public void DeleteCourse(int id) throws RemoteException;
    
    public void AddAdmin(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException;

    public void UpdateAdmin(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException;

    //public void DeleteAdmin(int id);
    
}
