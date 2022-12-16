/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import rmi.AdminInterface;
import Employee.*;
import Student.*;
import SuperiorAdmin.SuperiorAdmin;
import TA.TA;
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
public class Admin extends Employee implements AdminInterface {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private MongoCollection<Document> StudentCollection;
    private MongoCollection<Document> courseCollection;

    private Gson gson = new Gson();

    //ConnectionString connectionString = new ConnectionString("mongodb://admin:<password>@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority");
    public Admin() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        collection = database.getCollection("Depertmant");
        StudentCollection = database.getCollection("Student");
        courseCollection = database.getCollection("Course");

    }

    public Admin(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        super(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
    }

    
    public void RegisterStudent(Student student) throws RemoteException{
        StudentCollection.insertOne(Document.parse(gson.toJson(student)));
        System.out.println("Student Inserted Succesfully");
    }


    @Override
    public ArrayList<Student> getStudents() throws RemoteException {
        DBConnect db = new DBConnect();
        return db.getStudents();
    }

//    public void insertSuperiorAdmin(SuperiorAdmin sa){
//                saCollection.insertOne(Document.parse(gson.toJson(sa)));
//                System.out.println("Inserted");
//    }
    @Override
    public void UpdateStudent(Student student) throws RemoteException {
        Document doc = Document.parse(gson.toJson(student));
        StudentCollection.replaceOne(Filters.eq("StudentID", student.getStudentID()), doc);
        System.out.println("Updated Successfully");
    }

    @Override
    public void UpdateStudentStatus(Student student, String status) throws RemoteException {
//        Document doc = Document.parse(gson.toJson(student));
//        StudentCollection.replaceOne(Filters.eq("StudentStatus", student.getStudentID()), doc);
//        System.out.println("Updated Successfully");
    }

    @Override
    public void DeleteStudent(Student studentID) throws RemoteException {
        StudentCollection.deleteOne(Filters.eq("StudentID", studentID.getStudentID()));
        System.out.println("Deleted Successfully");
    }

    public ArrayList<Complaint> viewPendingComplaints() throws RemoteException {
        return viewPendingComplaints();
    }

    @Override
    public void HandleComplaint() throws RemoteException {

    }

    public void AddCourseTA(int courseid, TA ta) throws RemoteException {
        System.out.println("Error");
        Document doc1 = Document.parse(gson.toJson(ta));
        courseCollection.updateOne(Filters.eq("CourseID", courseid), Updates.set("CourseTAs", doc1));
    }

    public void RemoveCourseTA(int courseid) throws RemoteException {
        System.out.println("Error");
        Document doc = null;
        courseCollection.updateOne(Filters.eq("CourseID", courseid), Updates.set("CourseTAs", doc));
    }
    
      public void UpdateCourseTitle(int courseid, String title) throws RemoteException {
        System.out.println("Title Edited");
        Document doc = Document.parse(gson.toJson(title));
        courseCollection.updateOne(Filters.eq("CourseID", courseid), Updates.set("CourseTitle",doc));
        }
      
       public void DeleteCourse(String coursename) throws RemoteException{
        StudentCollection.deleteOne(Filters.eq("StudentID", coursename));
        System.out.println("Deleted Successfully");
    }


}
