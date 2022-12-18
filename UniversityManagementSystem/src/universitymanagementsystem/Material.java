/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import java.rmi.RemoteException;
import java.util.ArrayList;
import rmi.MaterialInterface;
import Student.*;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author ahmedwaleed
 */
//MaterialCollection
public class Material extends UnicastRemoteObject implements MaterialInterface, ViewMaterial {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> MaterialCollection;
    private MongoCollection<Document> courseCollection;

    private int ID;
    private String MaterialTitle;
    private boolean MaterialVisibility;
    private int CourseID;
    private Gson gson;

    public Material() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        MaterialCollection = database.getCollection("Material");
        courseCollection = database.getCollection("Course");
        gson = new Gson();

    }

    public Material(int ID, String MaterialTitle, boolean MaterialVisibility, int CourseID) throws RemoteException {
        this.ID = ID;
        this.MaterialTitle = MaterialTitle;
        this.MaterialVisibility = MaterialVisibility;
        this.CourseID = CourseID;
    }

    @Override
    public int getID() throws RemoteException {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String getMaterialTitle() throws RemoteException {
        return MaterialTitle;
    }

    public void setMaterialTitle(String MaterialTitle) {
        this.MaterialTitle = MaterialTitle;
    }

    @Override
    public boolean isMaterialVisibility() throws RemoteException {
        return MaterialVisibility;
    }

    public void setMaterialVisibility(boolean MaterialVisibility) {
        this.MaterialVisibility = MaterialVisibility;
    }

    @Override
    public int getCourseID() throws RemoteException {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    @Override
    public void changeMaterialVisibility(Boolean newVisibility) throws RemoteException {
        this.MaterialVisibility = newVisibility;
    }

    public void changeMaterialFileUrl(String newUrl) {

    }

    @Override
    public void changeMaterialTitle(String title) throws RemoteException {
        this.MaterialTitle = title;
    }

    @Override
    public void AddCourseMaterial(int ID, String MaterialTitle, boolean MaterialVisibility, int CourseID) throws RemoteException {
        Material m = new Material(ID, MaterialTitle, MaterialVisibility, CourseID);
        MaterialCollection.insertOne(Document.parse(gson.toJson(m)));
        System.out.println("File Inserted Succesfully");
    }

    public void AddCourseMaterialByDoctorID(int ID, String MaterialTitle, boolean MaterialVisibility, int DoctorID) throws RemoteException {
        Course c = new Course();
        c.getCoursebyDoctorID(DoctorID);
        System.out.println(c.getCourseID());
        Material m = new Material(ID, MaterialTitle, MaterialVisibility, c.getCourseID());
        MaterialCollection.insertOne(Document.parse(gson.toJson(m)));
        System.out.println("File Inserted Succesfully");
    }

    @Override
    public void RemoveCourseMaterial(int id) throws RemoteException {

        MaterialCollection.deleteOne(Filters.eq("ID", id));
        System.out.println("File Deleted Successfully");
    }

    @Override
    public void UpdateMaterialTitle(int matid, String title) throws RemoteException {
        System.out.println("Title Edited");

        MaterialCollection.updateOne(Filters.eq("ID", matid), Updates.set("MaterialTitle", title));
    }

    @Override
    public void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException {
        System.out.println("Visibility Edited");

        MaterialCollection.updateOne(Filters.eq("ID", matid), Updates.set("MaterialVisibility", vis));
    }

    @Override
    public void UpdateMaterialCourse(int matid, int cid) throws RemoteException {
        System.out.println("Course Edited");

        MaterialCollection.updateOne(Filters.eq("ID", matid), Updates.set("CourseID", cid));
    }

    public void registerObserv(Observer o) {

    }

    public void notifyObservers(Observer o) {

    }

    public void removeObserv(Observer o) {

    }

    @Override
    public ArrayList<Material> getMaterials(int courseID) {
//      ArrayList<Material>result = new ArrayList();
//      ArrayList<Document>docs ;//= collection.find(Filters.eq("CourseID", courseID)).into(new ArrayList<Document>());
//      
//      for (int i = 0; i < docs.size(); i++) {
//            String jsonResult = docs.get(i).toJson();
//            result.add(gson.fromJson(jsonResult, Material.class));
//        }
//        return result;
//      
        return null;
    }

}
