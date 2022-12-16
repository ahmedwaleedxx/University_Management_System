/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import Student.*;
import java.rmi.*;
import java.util.*;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public interface AdminInterface extends Remote {

    public void RegisterStudent(Student student) throws RemoteException;

    public void UpdateStudent(Student student) throws RemoteException;

    public void UpdateStudentStatus(Student student, String status) throws RemoteException;

    public void DeleteStudent(Student studentID) throws RemoteException;

    public ArrayList<Complaint> viewPendingComplaints() throws RemoteException;

    public void HandleComplaint() throws RemoteException;
}
