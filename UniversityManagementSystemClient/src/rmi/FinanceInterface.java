/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author farouuk
 */
public interface FinanceInterface extends Remote {

    public void setDoctorSalary(int employeeID, Double salary);

    public void setTASalary(int employeeID, Double salary);

    public void setAdminSalary(int employeeID, Double salary);

    public void setSuperiorAdminSalary(int employeeID, Double salary);

    public void setFinanceSalary(int employeeID, Double salary);

    public ArrayList<EmployeeInterface> getDoctors() throws RemoteException;

    public ArrayList<EmployeeInterface> getTAs() throws RemoteException;

    public ArrayList<EmployeeInterface> getAdmins() throws RemoteException;

    public ArrayList<EmployeeInterface> getSuperiorAdmins() throws RemoteException;

    public ArrayList<EmployeeInterface> getFinancier() throws RemoteException;

}
