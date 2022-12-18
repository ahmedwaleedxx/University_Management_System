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
public interface NotificationsInterface extends Remote{

    String getFacultyName()throws RemoteException;

    String getNotificationContent()throws RemoteException;

    int getNotificationID()throws RemoteException;

    void setFacultyName(String FacultyName)throws RemoteException;

    void setNotificationContent(String NotificationContent)throws RemoteException;

    void setNotificationID(int NotificationID)throws RemoteException;
    
}
