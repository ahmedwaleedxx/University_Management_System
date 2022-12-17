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
public interface AdminInterface extends Remote {

    public void RegisterStudent(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty
);

    public void UpdateStudent(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty);

    public void UpdateStudentStatus(Student student, String status);

    public void DeleteStudent(int StudentID);

    public ArrayList<Student> getStudents() throws RemoteException;
//
//    public ArrayList<Complaint> viewPendingComplaints();

    public void HandleComplaint();

    public Student students(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty) throws RemoteException;

}
