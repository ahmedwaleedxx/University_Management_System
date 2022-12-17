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
public interface EmployeeInterface extends Remote{

    public int getEmployeeID() throws RemoteException;

    public String getEmployeeFName() throws RemoteException;

    public String getEmployeeLName() throws RemoteException;

    public String getEmail() throws RemoteException;

    public String getPassword() throws RemoteException;

    public float getEmployeeSalary() throws RemoteException;

    public ArrayList<String> getEmployeeWorkingHours() throws RemoteException;

    public String getEmployeeBankAccountIBAN() throws RemoteException;

    public String getEmployeeType() throws RemoteException;
}
