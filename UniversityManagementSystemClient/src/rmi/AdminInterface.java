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

    public void RegisterStudent(Student student);

    public void UpdateStudent(Student student);

    public void UpdateStudentStatus(Student student, String status);

    public void DeleteStudent(Student studentID);

    public ArrayList<Student> getStudents() throws RemoteException;
//
//    public ArrayList<Complaint> viewPendingComplaints();

    public void HandleComplaint();
}
