/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

//import universitymanagementsystemclient.GUIs.SplashScreen;
import Admin.Admin;
import Doctor.Doctor;
import Employee.Employee;
import Finance.Finance;
import rmi.user;
import Student.Student;
import SuperiorAdmin.SuperiorAdmin;
import TA.TA;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.AdminInterface;
import rmi.DoctorInterface;
import rmi.FinanceInterface;
import rmi.MaterialInterface;
import rmi.SuperiorAdminInterface;

// import PackageName.ClassName;
/**
 *
 * @author ahmedwaleed
 */
public class UniversityManagementSystem {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        //Calling the class for the database 
        DBConnect db = new DBConnect();

        // Here we create our remote object
        user student = new Student();
        user superior = new SuperiorAdmin();
        user admin = new Admin();
        user finance = new Finance();
        user doctor = new Doctor();
        user tas = new TA();
        user employee = new Employee();
        //user fin = new Finance();

        MaterialInterface material = new Material();
        AdminInterface adminInterface = new Admin();
        Student st = new Student();
        SuperiorAdminInterface superiorinterface = new SuperiorAdmin();
        FinanceInterface financeinterface =  new Finance();
// An RMI Registry initialized on port 1099
        Registry r = LocateRegistry.createRegistry(1099);
        DoctorInterface doctorr=new Doctor();

        // Our remote object g is binded to the name "grade"
        r.bind("database", db);
        r.bind("student", student);
        r.bind("employee", employee);
        r.bind("admin", admin);
        r.bind("doctor", doctor);
        r.bind("ta", tas);
        r.bind("finance", finance);
        r.bind("superior", superior);
        
        
        
        r.bind("admininterface", adminInterface);
        r.bind("financeinterface", financeinterface);
        r.bind("superiorinterface", superiorinterface);
        r.bind("material", material);
        r.bind("doctorinterface", doctorr);

Finance f = new Finance();
//f.setDoctorSalary(1, 66.5);
Faculty f1 = new Faculty();
//f1.setFacultyFees(1, 22.2);

Admin a = new Admin();
//a.AddFinance(11, "Ahmed", "Waleed", "ahmed", "12345", 5, null, "CIB", "Finance");
        
Material m = new Material();

//a.getStudents();



SuperiorAdmin ss = new SuperiorAdmin();
//ss.getDoctors();
//ss.AddCourse(2, "MARIO", 1, "mario", "ICS");
//m.AddCourseMaterial(2, "MARIOSE22222222", true, 1);
//m.RemoveCourseMaterial(2);
//m.UpdateMaterialVisibility(1, false);

        Course c = new Course();
     // c.getMaterialbyDoctorID(1);
        // c.getCoursebyDoctorID(1);
///c.RemoveCourseTA(1);
//c.UpdateCourseTitle(1, "AOOP");
        //\\c.getMaterialbyCourseID(1);
        //Admin a = new Admin();
        //Student s1 = new Student();
        // r.bind("student2", s1);
// StudentFName, StudentLName, Email, Password, 0, true, true, Major, Faculty);//= new Student(9, "Mario", "Medhat", "mario@gmail.com", "123", 55, true, false, "Networks", "ICS", null, null);
        //s1.students(9, "Waleed", "Medhat", "mario@gmail.com", "123", 55, true, false, "Networks", "ICS");
        //a.RegisterStudent(20, "Rowan", "Ahmed", "ahmed", "123", 55, true, false, "CS", "Engineering");
        // a.RegisterStudent(s1);
        // a.DeleteStudent(s1);
        //db.getStudents();
        //db.Login("test@test.com", "testing", "Student");
//public Student(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty, ArrayList<Course> Courses, ArrayList<Observer> Observers) {
//SuperiorAdmin sa = new SuperiorAdmin(1, "Superior", "Admin", "superioradmin@wmf.edu.eg", "1234", 500, null, "CIB", "Superior Admin");
//        SuperiorAdmin sa = new SuperiorAdmin();
//        ArrayList<Material> materials = new ArrayList<>();
//        Admin a = new Admin();
//        a.Login("ahmed", "123444", "Admin");
        //sa.AddAdmin(1, "3ammak Mahmoud", "Osama", "ahmed", "123", 55, null, "ASBC", "Admin");
        //sa.UpdateAdmin(1, "Ahmed", "Waleed", "ahmed", "123", 55, null, "HSBC", "Admin");
//        Doctor d = new Doctor(1, "Abeer", "Hamdy", "abeerhamdy@wmf.edu.eg", "1234", 1000, null, "CIB", "Doctor", null, null);
//        TA ta = new TA(5, "Waleed", "Sherif", "meriam.sherif@wmf.edu.eg", "1234", 500, null, "CIB", "TA", 1);
//        TA ta2 = new TA(6, "Farouk", "Hesham", "meriam.sherif@wmf.edu.eg", "1234", 500, null, "CIB", "TA", 1);
//        Material m = new Material(1, "Lecture 1", true, 1);
//        materials.add(m);
//        //Course c = new Course(1, "AOOSE", d, null, "aoose@wmf.edu.eg", "ICS", materials);
//        Faculty f = new Faculty(2, "ICS", "Omar Karam", "omar.karam@wmf.edu.eg", null);
//
//        Student s = new Student(2, "Ahmed", "Waleed", "testing@test.com", "testing", 0, false, true, "SE", "ICS", null, null);
// a.RemoveCourseTA(1, ta2);
//sa.AddCourse(c);
//sa.AssignTA(ta);
//sa.AssignTA(ta2);
//sa.RemoveTA(ta);
//sa.UpdateDoctorInfo(d);
//sa.AddFaculty(f);
//c.AddCourseMaterial(m);
//sa.DeleteCourse(c);
//Admin a1 = new Admin(1, "Ahmed", "Waleed", "ahmedwaleed@wmf.edu.eg", "1234", 1000, null, "CIB", "Admin");
//a.getStudents();
// a.AddCourseTA(1, ta2);
// ArrayList<Student>st = new ArrayList<>();
// st.add(s);
// System.out.println(st);
        System.out.println("Server is ready");
    }

}
