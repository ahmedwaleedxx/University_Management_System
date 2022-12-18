/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import universitymanagementsystem.Material;

/**
 *
 * @author farouuk
 */
public interface DoctorInterface extends Remote {
    
    
    public ArrayList<MaterialInterface> getMaterialbyDoctorID(int id) throws RemoteException;
    
        public void UpdateMaterialTitle(int matid, String title) throws RemoteException;

    public void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException;

    public void UpdateMaterialCourse(int matid, int cid) throws RemoteException;
    
    public void RemoveCourseMaterial(int id) throws RemoteException;
       // void AddCourseMaterial(Material m);

    //void HandleComplaint();

   // void RemoveCourseMaterial(Material m) throws RemoteException;

//    void UpdateCourseTitle(int courseid, String title) throws RemoteException;
// 
//    void UpdateMaterialCourse(int matid, int cid) throws RemoteException;
//
//    void UpdateMaterialTitle(int matid, String title) throws RemoteException;
//
//    void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException;


    //void addCourseMaterial(Course course, Material material);

    //void addTAtoCourse(Course course, TA ta);

   // void assignTATasks(TA ta, String task);

    //Course getAssignedCourse();

   // TA getAssignedTA();

   // void removeCourseMaterial(Course course, Material courseMaterial);

   // void removeCourseTA(Course course, TA ta);

  //  void sendAnnouncements(Student student);

   // void setAssignedCourse(Course AssignedCourse);

   // void setAssignedTA(TA AssignedTA);

    //void setGrades(Course assignedCourse, Student student);

    //void setMaterialVisibility(Material material, Boolean isVisible);
}
