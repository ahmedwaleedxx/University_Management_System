/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.NotificationsInterface;

/**
 *
 * @author ahmedwaleed
 */
public class Notification extends UnicastRemoteObject implements NotificationsInterface {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> MaterialCollection;
    private MongoCollection<Document> NotificationCollection;
    private Gson gson;

//   client  = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
//    database  = client.getDatabase("UniversityManagementSystem");
//    NotificationCollection  = database.getCollection("Notification");
    private int NotificationID;
    private String NotificationContent;
    private String FacultyName;

    public Notification() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        NotificationCollection = database.getCollection("Notification");
        gson = new Gson();
    }

    public Notification(int NotificationID, String NotificationContent, String FacultyName) throws RemoteException {
        this.NotificationID = NotificationID;
        this.NotificationContent = NotificationContent;
        this.FacultyName = FacultyName;
    }

    @Override
    public int getNotificationID() throws RemoteException {
        return NotificationID;
    }

    @Override
    public void setNotificationID(int NotificationID) throws RemoteException {
        this.NotificationID = NotificationID;
    }

    @Override
    public String getNotificationContent() {
        return NotificationContent;
    }

    @Override
    public void setNotificationContent(String NotificationContent) throws RemoteException {
        this.NotificationContent = NotificationContent;
    }

    @Override
    public String getFacultyName() {
        return FacultyName;
    }

    @Override
    public void setFacultyName(String FacultyName) throws RemoteException {
        this.FacultyName = FacultyName;
    }
    
    public void sendNotification(int ID, String Content, String Faculty) throws RemoteException{
        Notification notification = new Notification(ID, Content, Faculty);
        NotificationCollection.insertOne(Document.parse(gson.toJson(notification)));
        System.out.println("Notification Inserted");
    }

}
