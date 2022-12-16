/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import Doctor.*;
import TA.*;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author ahmedwaleed
 */
public class Course {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> courseCollection;
    private MongoCollection<Document> materialCollection;

    private Gson gson = new Gson();

    private int CourseID;
    private String CourseTitle;
    private Doctor CourseDoctor;
    private ArrayList<TA> CourseTAs;
    private String Mail;
    private String Faculty;
    private ArrayList<Material> CourseMaterial;

    public Course(int CourseID, String CourseTitle, Doctor CourseDoctor, ArrayList<TA> CourseTAs, String Mail, String Faculty, ArrayList<Material> CourseMaterial) throws RemoteException {
        this.CourseID = CourseID;
        this.CourseTitle = CourseTitle;
        this.CourseDoctor = CourseDoctor;
        this.CourseTAs = CourseTAs;
        this.Mail = Mail;
        this.Faculty = Faculty;
        this.CourseMaterial = CourseMaterial;
    }

    public Course() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        courseCollection = database.getCollection("Course");
        materialCollection = database.getCollection("Material");

    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public void setCourseTitle(String CourseTitle) {
        this.CourseTitle = CourseTitle;
    }

    public Doctor getCourseDoctor() {
        return CourseDoctor;
    }

    public void setCourseDoctor(Doctor CourseDoctor) {
        this.CourseDoctor = CourseDoctor;
    }

    public ArrayList<TA> getCourseTAs() {
        return CourseTAs;
    }

    public void setCourseTAs(ArrayList<TA> CourseTAs) {
        this.CourseTAs = CourseTAs;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    public ArrayList<Material> getCourseMaterial() {
        return CourseMaterial;
    }

    public void setCourseMaterial(ArrayList<Material> CourseMaterial) {
        this.CourseMaterial = CourseMaterial;
    }

    public void AddCourseMaterial(Material material) throws RemoteException {
        courseCollection.insertOne(Document.parse(gson.toJson(material)));
        System.out.println(" Inserted Succesfully");
    }

    public void UpdateCourseTitle(String title) {
        Document doc = Document.parse(gson.toJson(title));
        courseCollection.replaceOne(Filters.eq("CourseTitle", getCourseTitle()), doc);
        System.out.println("Updated Successfully");
    }

    public void AddCourseTA( TA ta) {
        courseCollection.insertOne(Document.parse(gson.toJson(ta.getEmployeeFName())));
        System.out.println(" Inserted Succesfully");
    }

}
