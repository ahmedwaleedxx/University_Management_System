/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperiorAdmin;

import Admin.Admin;
import Doctor.*;
import Employee.*;
import TA.*;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.CourseInterface;
import rmi.EmployeeInterface;
import rmi.FacultyInterface;
import rmi.SuperiorAdminInterface;
import rmi.user;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public class SuperiorAdmin extends Employee implements SuperiorAdminInterface, user {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> AdminCollection;
    private MongoCollection<Document> CourseCollection;
    private MongoCollection<Document> DoctorCollection;
    private MongoCollection<Document> TACollection;
    private MongoCollection<Document> FacuCollection;
    private Gson gson;

    public SuperiorAdmin() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        // Initialize

        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        DoctorCollection = database.getCollection("Doctor");
        AdminCollection = database.getCollection("Admin");
        TACollection = database.getCollection("TA");
        FacuCollection = database.getCollection("Faculty");
        CourseCollection = database.getCollection("Course");
        gson = new Gson();
    }

    public SuperiorAdmin(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        super(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
    }

    private static SuperiorAdmin instance;

    public static SuperiorAdmin getInstance() {
        return instance;
    }

//    @Override
//    public void AssignDoctor(Doctor doctor) throws RemoteException {
//        DoctorCollection.insertOne(Document.parse(gson.toJson(doctor)));
//        System.out.println("Doctor Inserted Succesfully");
//    }
//    @Override
//    public void UpdateDoctorInfo(Doctor doctor) throws RemoteException {
//        Document doc = Document.parse(gson.toJson(doctor));
//        DoctorCollection.replaceOne(Filters.eq("EmployeeID", doctor.getEmployeeID()), doc);
//        System.out.println("Updated Successfully");
//    }
//    @Override
//    public void RemoveDoctor(Doctor doctor) throws RemoteException {
//        DoctorCollection.deleteOne(Filters.eq("EmployeeID", doctor.getEmployeeID()));
//        System.out.println("Deleted Successfully");
//    }
//    @Override
//    public void AssignTA(TA ta) throws RemoteException {
//        TACollection.insertOne(Document.parse(gson.toJson(ta)));
//        System.out.println("TA Inserted Succesfully");
//    }
//    @Override
//    public void UpdateTAInfo(TA ta) throws RemoteException {
//        Document doc = Document.parse(gson.toJson(ta));
//        TACollection.replaceOne(Filters.eq("EmployeeID", ta.getEmployeeID()), doc);
//        System.out.println("Updated Successfully");
//    }
//    @Override
//    public void RemoveTA(TA ta) throws RemoteException {
//        TACollection.deleteOne(Filters.eq("EmployeeID", ta.getEmployeeID()));
//        System.out.println("Deleted Successfully");
//    }
//    @Override
//    public void AddFaculty(Faculty faculty) throws RemoteException {
//        FacuCollection.insertOne(Document.parse(gson.toJson(faculty)));
//        System.out.println("Faculty Inserted Succesfully");
//    }
//    @Override
//    public void UpdateFaculty(Faculty faculty) throws RemoteException {
//        Document doc = Document.parse(gson.toJson(faculty));
//        FacuCollection.replaceOne(Filters.eq("EmployeeID", faculty.getFacultyID()), doc);
//        System.out.println("Updated Successfully");
//    }
//    @Override
//    public void RemoveFaculty(Faculty facultyID) throws RemoteException {
//        FacuCollection.deleteOne(Filters.eq("FacultyID", facultyID.getFacultyID()));
//        System.out.println("Deleted Successfully");
//    }
//    @Override
//    public void AddCourse(Course c) throws RemoteException {
//        CourseCollection.insertOne(Document.parse(gson.toJson(c)));
//        System.out.println("Course Inserted Succesfully");
//    }
//    @Override
//    public void UpdateCourse(Course c) throws RemoteException {
//        Document doc = Document.parse(gson.toJson(c));
//        CourseCollection.replaceOne(Filters.eq("CourseID", c.getCourseID()), doc);
//        System.out.println("Updated Successfully");
//    }
//    @Override
//    public void DeleteCourse(Course c) throws RemoteException {
//        CourseCollection.deleteOne(Filters.eq("CourseID", c.getCourseID()));
//        System.out.println("Deleted Successfully");
//    }
    @Override
    public void AddAdmin(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        Admin admin = new Admin(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
        AdminCollection.insertOne(Document.parse(gson.toJson(admin)));
        System.out.println("Admin Inserted Succesfully");
    }

    @Override
    public void UpdateAdmin(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {

        Admin admin = new Admin(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
        Document doc = Document.parse(gson.toJson(admin));
        AdminCollection.replaceOne(Filters.eq("EmployeeID", admin.getEmployeeID()), doc);
        System.out.println("Updated Successfully");
    }

    @Override
    public user Login(String email, String password, String usertype) throws RemoteException {
        DBConnect db = new DBConnect();
        user u = db.Login(email, password, usertype);
        return u;

    }

    @Override
    public void AssignDoctor(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        Doctor doctor = new Doctor(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
        DoctorCollection.insertOne(Document.parse(gson.toJson(doctor)));
        System.out.println("Doctor Inserted Succesfully");

    }

    @Override
    public void UpdateDoctorInfo(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        Doctor doctor = new Doctor(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
        Document doc = Document.parse(gson.toJson(doctor));
        DoctorCollection.replaceOne(Filters.eq("EmployeeID", doctor.getEmployeeID()), doc);
        System.out.println("Updated Successfully");
    }

    @Override
    public void RemoveDoctor(int id) throws RemoteException {
        DoctorCollection.deleteOne(Filters.eq("EmployeeID", id));
        System.out.println("Deleted Successfully");
    }

    @Override
    public void AssignTA(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        TA ta = new TA(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType, EmployeeID);
        TACollection.insertOne(Document.parse(gson.toJson(ta)));
        System.out.println("TA Inserted Succesfully");
    }

    @Override
    public void UpdateTAInfo(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        TA ta = new TA(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType, EmployeeID);
        Document doc = Document.parse(gson.toJson(ta));
        TACollection.replaceOne(Filters.eq("EmployeeID", ta.getEmployeeID()), doc);
        System.out.println("Updated Successfully");
    }

    @Override
    public void RemoveTA(int id) throws RemoteException {
        TACollection.deleteOne(Filters.eq("EmployeeID", id));
        System.out.println("Deleted Successfully");
    }

    @Override
    public void AddFaculty(int FacultyID, String Name, String DeanName, String Mail, double Fees) throws RemoteException {
        Faculty faculty = new Faculty(FacultyID, Name, DeanName, Mail, Fees);
        FacuCollection.insertOne(Document.parse(gson.toJson(faculty)));
        System.out.println("Faculty Inserted Succesfully");
    }

    @Override
    public void UpdateFaculty(int FacultyID, String Name, String DeanName, String Mail, double Fees) throws RemoteException {
        Faculty faculty = new Faculty(FacultyID, Name, DeanName, Mail, Fees);
        Document doc = Document.parse(gson.toJson(faculty));
        FacuCollection.replaceOne(Filters.eq("FacultyID", faculty.getFacultyID()), doc);
        System.out.println("Updated Successfully");
    }

    @Override
    public void RemoveFaculty(int id) throws RemoteException {
        FacuCollection.deleteOne(Filters.eq("FacultyID", id));
        System.out.println("Deleted Successfully");
    }

    @Override
    public void AddCourse(int CourseID, String CourseTitle, int CourseDoctor, String Mail, String Faculty) throws RemoteException {
        Course c = new Course(CourseID, CourseTitle, CourseDoctor, Mail, Faculty);
        CourseCollection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Course Inserted Succesfully");
    }

    @Override
    public void UpdateCourse(int CourseID, String CourseTitle, int CourseDoctor, String Mail, String Faculty) throws RemoteException {
        Course c = new Course(CourseID, CourseTitle, CourseDoctor, Mail, Faculty);
        Document doc = Document.parse(gson.toJson(c));
        CourseCollection.replaceOne(Filters.eq("CourseID", c.getCourseID()), doc);
        System.out.println("Updated Successfully");
    }

    @Override
    public void DeleteCourse(int id) throws RemoteException {
        CourseCollection.deleteOne(Filters.eq("CourseID", id));
        System.out.println("Deleted Successfully");
    }

    @Override
    public ArrayList<Employee> getDoctors() throws RemoteException {
        DBConnect db = new DBConnect();
        return db.getDoctors();
    }

    @Override
    public ArrayList<Employee> getTAs() throws RemoteException {
        DBConnect db = new DBConnect();
        return db.getTAs();
    }

    @Override
    public ArrayList<Employee> getAdmins() throws RemoteException {
        DBConnect db = new DBConnect();
        return db.getAdmins();
    }

    @Override
    public ArrayList<FacultyInterface> getFaculties() throws RemoteException {
        DBConnect db = new DBConnect();
        return db.getFaculties();
    }

    @Override
    public ArrayList<CourseInterface> getCourses() throws RemoteException {
        DBConnect db = new DBConnect();
        return db.getCourses();
    }

}
