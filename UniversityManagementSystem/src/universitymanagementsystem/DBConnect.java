/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import Admin.Admin;
import Doctor.Doctor;
import Employee.Employee;
import Finance.Finance;
import com.google.gson.Gson;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import java.util.List;
import java.util.logging.*;
import Student.Student;
import SuperiorAdmin.SuperiorAdmin;
import TA.TA;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.bson.Document;
import rmi.DBInterface;
import rmi.user;

/**
 *
 * @author ahmedwaleed
 */
public class DBConnect extends UnicastRemoteObject implements DBInterface {

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
    private Gson gson = new Gson();

    //ConnectionString connectionString = new ConnectionString("mongodb://admin:<password>@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority");
    public DBConnect() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem"); // Database name
        collection = database.getCollection("Depertmant"); // Collection name
        
        StudentsCollection = database.getCollection("Student");
        EmployeesCollection = database.getCollection("Employee");
        CoursesCollection = database.getCollection("Course");
        facultiesCollection = database.getCollection("Faculty");
        doctorcollection = database.getCollection("Doctor");
        tacollection = database.getCollection("TA");
        superioradmincollection = database.getCollection("Superior Admin");
        financecollection = database.getCollection("Finance");

    }

    public user Login(String email, String Password, String userType) {

        switch (userType) {
            case "Student":
                Document student = StudentsCollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (student == null) {
                    return null;
                }
                Student studentresult = gson.fromJson(student.toJson(), Student.class);

                return studentresult;

            case "Doctor":
                Document doctor = doctorcollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (doctor == null) {
                    return null;
                }
                Doctor doctorresult = gson.fromJson(doctor.toJson(), Doctor.class);
                return doctorresult;
            case "Admin":
                Document admin = adminCollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (admin == null) {
                    return null;
                }
                Admin adminresult = gson.fromJson(admin.toJson(), Admin.class);
                return adminresult;
            case "TA":
                Document ta = tacollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (ta == null) {
                    return null;
                }
                TA taresult = gson.fromJson(ta.toJson(), TA.class);
                return taresult;
            case "Superior Admin":
                Document superioradmin = superioradmincollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (superioradmin == null) {
                    return null;
                }
                SuperiorAdmin superiorresult = gson.fromJson(superioradmin.toJson(), SuperiorAdmin.class);
                return superiorresult;
            case "Finance":
                Document finance = financecollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (finance == null) {
                    return null;
                }
                Finance financeresult = gson.fromJson(finance.toJson(), Finance.class);
                return financeresult;
            default:
                break;
        }
        return null;
    }
    
    
    
    
    
    
    

    @Override
    public MongoDatabase getDatabase() throws RemoteException {
        return database;
    }

    @Override
    public void SignUpStudent(Student s) throws RemoteException {
        StudentsCollection.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Student Inserted Succesfully");
    }

    @Override
    public void UpdateStudent(Student s) throws RemoteException {
        Document doc = Document.parse(gson.toJson(s));
        StudentsCollection.replaceOne(Filters.eq("StudentID", s.getStudentID()), doc);
    }

    @Override
    public void DeleteStudent(Student s) throws RemoteException {
        StudentsCollection.deleteOne(Filters.eq("StudentID", s.getStudentID()));
    }

    @Override
    public Employee getEmployee(String email, String password, String EmployeeType) throws RemoteException {
        Document employee = EmployeesCollection.find(Filters.eq("email", email)).first();
        Employee result = gson.fromJson(employee.toJson(), Employee.class);
        if (result.getPassword() == password && result.getEmployeeType() == EmployeeType) {
            return result;
        } else {
            return null;
        }
    }

    @Override
    public Course getCourse(int Course) throws RemoteException {
        Document course = CoursesCollection.find(Filters.eq("CourseID", Course)).first();
        Course result = gson.fromJson(course.toJson(), Course.class);
        return result;
    }

    @Override
    public ArrayList<Student> getStudents() throws RemoteException {
        ArrayList<Document> students = StudentsCollection.find().into(new ArrayList<>());
        ArrayList<Student> finalList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student result = gson.fromJson(students.get(i).toJson(), Student.class);
            System.out.println(result.getEmail() + " " + result.getPassword());
            finalList.add(result);
        }
        return finalList;
    }

    @Override
    public ArrayList<Faculty> getFaculties() throws RemoteException {
        ArrayList<Document> facs = (ArrayList<Document>) facultiesCollection.find();
        ArrayList<Faculty> finalFacs = new ArrayList<>();
        for (int i = 0; i < facs.size(); i++) {
            Faculty result = gson.fromJson(facs.get(i).toJson(), Faculty.class);
            finalFacs.add(result);
        }
        return finalFacs;
    }

    @Override
    public void close() throws RemoteException {
        client.close();
    }

}
