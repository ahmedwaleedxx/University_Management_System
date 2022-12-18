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
public interface FacultyInterface extends Remote{

    int getFacultyID() throws RemoteException;

    String getDeanName() throws RemoteException;

    String getMail() throws RemoteException;

    String getName() throws RemoteException;

    public double getFees() throws RemoteException;
}
