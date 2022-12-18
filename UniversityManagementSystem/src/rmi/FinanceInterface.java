/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import Employee.Employee;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author farouuk
 */
public interface FinanceInterface extends Remote {

    public void setAdminSalary(int employeeID, Double salary) throws RemoteException;

    public void setDoctorSalary(int employeeID, Double salary) throws RemoteException;

    public void setFinanceSalary(int employeeID, Double salary) throws RemoteException;

    public boolean setPaymentStatus(int TransactionID, boolean Status) throws RemoteException;

    public void setSuperiorAdminSalary(int employeeID, Double salary) throws RemoteException;

    public void setTASalary(int employeeID, Double salary) throws RemoteException;

    public ArrayList<Employee> getDoctors() throws RemoteException;

    public ArrayList<Employee> getTAs() throws RemoteException;

    public ArrayList<Employee> getAdmins() throws RemoteException;

    public ArrayList<Employee> getSuperiorAdmins() throws RemoteException;

    public ArrayList<Employee> getFinancier() throws RemoteException;
}
