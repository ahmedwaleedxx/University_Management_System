/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import Doctor.Doctor;
import TA.TA;
import java.rmi.*;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public interface SuperiorAdminInterface extends Remote {

    public void AssignDoctor(Doctor doctor) throws RemoteException;

    public void UpdateDoctorInfo(Doctor doctor) throws RemoteException;

    public void RemoveDoctor(Doctor doctor) throws RemoteException;

    public void AssignTA(TA ta) throws RemoteException;

    public void UpdateTAInfo(TA ta) throws RemoteException;

    public void RemoveTA(TA ta) throws RemoteException;

    public void AddFaculty(Faculty faculty) throws RemoteException;

    public void UpdateFaculty(Faculty faculty) throws RemoteException;

    public void RemoveFaculty(Faculty facultyID) throws RemoteException;

    public void AddCourse(Course c) throws RemoteException;

    public void UpdateCourse(Course c) throws RemoteException;

    public void DeleteCourse(Course c) throws RemoteException;
}
