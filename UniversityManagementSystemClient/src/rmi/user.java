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
public interface user extends Remote{

    public user Login(String email, String password, String usertype) throws RemoteException;

    public void ChangePassword(String OldPassword, String NewPassword) throws RemoteException;

    public void ForgotPassword(String emailAddress) throws RemoteException;
}
