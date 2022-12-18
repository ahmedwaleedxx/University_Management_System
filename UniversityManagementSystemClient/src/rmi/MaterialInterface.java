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
public interface MaterialInterface extends Remote {

    public int getID() throws RemoteException;

    public String getMaterialTitle() throws RemoteException;

    public boolean isMaterialVisibility() throws RemoteException;

    public int getCourseID() throws RemoteException;

    public void changeMaterialVisibility(Boolean newVisibility) throws RemoteException;

    public void changeMaterialTitle(String title) throws RemoteException;

    public void AddCourseMaterial(int ID, String MaterialTitle, boolean MaterialVisibility, int CourseID) throws RemoteException;

    public void RemoveCourseMaterial(int id) throws RemoteException;

    public void UpdateMaterialTitle(int matid, String title) throws RemoteException;

    public void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException;

    public void UpdateMaterialCourse(int matid, int cid) throws RemoteException;
}
