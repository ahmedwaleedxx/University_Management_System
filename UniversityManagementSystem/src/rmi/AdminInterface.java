/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import Student.Student;
import TA.TA;
import java.rmi.*;
import java.util.*;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public interface AdminInterface extends Remote {

    public void RegisterStudent(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty) throws RemoteException;

    public void UpdateStudent(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty) throws RemoteException;

    public void UpdateStudentStatus(Student student, String status) throws RemoteException;

    public void DeleteStudent(int StudentID) throws RemoteException;

//    public ArrayList<Complaint> viewPendingComplaints() throws RemoteException;
    public ArrayList<Student> getStudents() throws RemoteException;

    public void HandleComplaint() throws RemoteException;

    
//      public rmi.Student students(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty) throws RemoteException;

}
