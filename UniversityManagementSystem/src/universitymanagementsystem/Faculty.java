/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import rmi.FacultyInterface;
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
import java.io.Serializable;
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
public class Faculty extends UnicastRemoteObject implements FacultyInterface, Serializable {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
//    private MongoCollection<Document> FinanceCollection;
//    private MongoCollection<Document> StudentCollection;
//    private MongoCollection<Document> EmployeeCollection;

    private MongoCollection<Document> facultiesCollection;

    private Gson gson;

    private int FacultyID;
    private String Name;
    private String DeanName;
    private String Mail;
    private ArrayList<Doctor> doctors;
    private double Fees;

    public Faculty() throws RemoteException {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        collection = database.getCollection("Depertmant");
        facultiesCollection = database.getCollection("Faculty");
        gson = new Gson();
    }

    public Faculty(int FacultyID, String Name, String DeanName, String Mail, double Fees) throws RemoteException {
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

    @Override
    public double getFees() throws RemoteException {
        return Fees;
    }

    public void setFees(double Fees) {
        this.Fees = Fees;
    }

    @Override
    public int getFacultyID() throws RemoteException {
        return FacultyID;
    }

    public void setFacultyID(int FacultyID) {
        this.FacultyID = FacultyID;
    }

    @Override
    public String getName() throws RemoteException {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String getDeanName() throws RemoteException {
        return DeanName;
    }

    public void setDeanName(String DeanName) {
        this.DeanName = DeanName;
    }

    @Override
    public String getMail() throws RemoteException {
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

//    public void AddFaculty(String faculty) throws RemoteException{
//        facultiesCollection.insertOne(Filters.eq("FacultyName", faculty));
//
//        System.out.println("Faculty Added");
//
//    }

    public void DeleteFaculty(int id) throws RemoteException{
        facultiesCollection.deleteOne(Filters.eq("FacultyID", id));

        System.out.println("Faculty Deleted");

    }
}
