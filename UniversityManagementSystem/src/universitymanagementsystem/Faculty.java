/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import Doctor.*;
import java.rmi.RemoteException;
import java.util.*;
import org.bson.Document;
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

/**
 *
 * @author ahmedwaleed
 */
public class Faculty {

    
       private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
//    private MongoCollection<Document> FinanceCollection;
//    private MongoCollection<Document> StudentCollection;
//    private MongoCollection<Document> EmployeeCollection;
    
      private MongoCollection<Document> facultiesCollection;
    
     private Gson gson = new Gson();
    
    private int FacultyID;
    private String Name;
    private String DeanName;
    private String Mail;
    private ArrayList<Doctor> doctors;
    private double Fees;

    public Faculty() {
        
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        collection = database.getCollection("Depertmant");
        facultiesCollection = database.getCollection("Faculty");
    }

    public Faculty(int FacultyID, String Name, String DeanName, String Mail, double Fees) {
        this.FacultyID = FacultyID;
        this.Name = Name;
        this.DeanName = DeanName;
        this.Mail = Mail;
        //this.doctors = doctors;
        this.Fees = Fees;
    }


//    public void setFacultyFees(Faculty FacultyName, Double fees) {
//   
//          FacultyCollection.insertOne(Document.parse(gson.toJson(FacultyName)));
//          FinanceCollection.insertOne(Document.parse(gson.toJson(fees)));
//        System.out.println("Fees Inserted Succesfully");
//
//    }
    
    
     public void setFacultyFees(int facultyID, double fees) throws RemoteException {
         
        
        
        facultiesCollection.updateOne(Filters.eq("FacultyID", facultyID), Updates.set("Fees", fees));
        
         System.out.println("Faculty Fees Added");
         
    }
     
     
     
 
    public int getFacultyID() {
        return FacultyID;
    }

    public void setFacultyID(int FacultyID) {
        this.FacultyID = FacultyID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDeanName() {
        return DeanName;
    }

    public void setDeanName(String DeanName) {
        this.DeanName = DeanName;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void AddDoctor(Doctor doct) {

    }

    public void UpdateFacultyInfo() {

    }
}
