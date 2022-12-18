/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance;

import Doctor.Doctor;
import rmi.FinanceInterface;
import Employee.*;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import universitymanagementsystem.*;
import java.rmi.server.UnicastRemoteObject;
import org.bson.BSON;
import rmi.user;

/**
 *
 * @author ahmedwaleed
 */
public class Finance extends Employee implements user, FinanceInterface {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private MongoCollection<Document> StudentsCollection;
    private MongoCollection<Document> EmployeesCollection;
    private MongoCollection<Document> CoursesCollection;
    private MongoCollection<Document> facultiesCollection;
    private MongoCollection<Document> adminCollection;
    private MongoCollection<Document> doctorcollection;
    private MongoCollection<Document> tacollection;
    private MongoCollection<Document> superioradmincollection;
    private MongoCollection<Document> financecollection;
    private Gson gson;

    public Finance() throws RemoteException {

        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        financecollection = database.getCollection("Finance");
        StudentsCollection = database.getCollection("Student");
        EmployeesCollection = database.getCollection("Employee");
        facultiesCollection = database.getCollection("Faculty");
        doctorcollection = database.getCollection("Doctor");
        tacollection = database.getCollection("TA");
        adminCollection = database.getCollection("Admin");
        superioradmincollection = database.getCollection("SuperiorAdmin");
gson = new Gson();
    }

    public Finance(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        super(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
    }

    @Override
    public boolean setPaymentStatus(int TransactionID, boolean Status) throws RemoteException{

        return false;
    }

    @Override
    public void setDoctorSalary(int employeeID, Double salary) throws RemoteException{

        //Doctor d = new Doctor();
        doctorcollection.updateOne(Filters.eq("EmployeeID", employeeID), Updates.set("EmployeeSalary", salary));

        System.out.println("Salary Added To Doctor");

    }

    @Override
    public void setTASalary(int employeeID, Double salary) throws RemoteException{
        // Document doc = Document.parse(gson.toJson(salary));

        tacollection.updateOne(Filters.eq("EmployeeID", employeeID), Updates.set("EmployeeSalary", salary));

        System.out.println("Salary Added To TA");

    }

    @Override
    public void setAdminSalary(int employeeID, Double salary) throws RemoteException {

        adminCollection.updateOne(Filters.eq("EmployeeID", employeeID), Updates.set("EmployeeSalary", salary));

        System.out.println("Salary Added To Admin");

    }

    @Override
    public void setSuperiorAdminSalary(int employeeID, Double salary)throws RemoteException {

        superioradmincollection.updateOne(Filters.eq("EmployeeID", employeeID), Updates.set("EmployeeSalary", salary));

        System.out.println("Salary Added To SuperiorAdmin");

    }

    @Override
    public void setFinanceSalary(int employeeID, Double salary) throws RemoteException{

        financecollection.updateOne(Filters.eq("EmployeeID", employeeID), Updates.set("EmployeeSalary", salary));

        System.out.println("Salary Added To Finance");

    }

    @Override
    public user Login(String email, String password, String usertype) throws RemoteException{
        DBConnect db = new DBConnect();
       return  db.Login(email, password, usertype);
        
    }
    
    
        @Override
    public ArrayList<Employee>getDoctors() throws RemoteException{
        DBConnect db = new DBConnect();
        return db.getDoctors();
    }
    
     @Override
         public ArrayList<Employee>getTAs() throws RemoteException{
        DBConnect db = new DBConnect();
        return db.getTAs();
    }
    
         
          @Override
         public ArrayList<Employee>getAdmins() throws RemoteException{
        DBConnect db = new DBConnect();
        return db.getAdmins();
    }
         
         
            @Override
         public ArrayList<Employee>getSuperiorAdmins() throws RemoteException{
        DBConnect db = new DBConnect();
        return db.getSuperiorAdmins();
    }
         
                 @Override
         public ArrayList<Employee>getFinancier() throws RemoteException{
        DBConnect db = new DBConnect();
        return db.getFinanciers();
    }

    
    
//    public void AddOverTimeBonus(int EmployeeID, Double overtimeBonus) {
//        
//    }
//
//    public void discountSalaryFromEmployee(int EmployeeID, Double percent) {
//
//    }
    public void HandleComplaint() {

    }

    public void respondToEnquiries(int EnquiryID, String message) {

    }

}
