/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ahmedwaleed
 */
public interface DoctorInterface extends Remote {

    public void AddCourseMaterial(MaterialInterface m) throws RemoteException;

    public void RemoveCourseMaterial(MaterialInterface m) throws RemoteException;

    public void UpdateMaterialTitle(int matid, String title) throws RemoteException;

    public void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException;

    public void UpdateMaterialCourse(int matid, int cid) throws RemoteException;

    public void UpdateCourseTitle(int courseid, String title) throws RemoteException;
}
