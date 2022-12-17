/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystemclient;

import GUIControllers.*;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import universitymanagementsystemclient.GUIs.SplashScreen;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rmi.user;
import universitymanagementsystemclient.GUIs.*;

/**
 *
 * @author ahmedwaleed
 */
public class UniversityManagementSystemClient {

    static void welcome() {
        // this is to lunch the gui by the splash :-
        SplashScreen welcome = new SplashScreen();
        welcome.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);
                welcome.percentagelbl.setText(i + " %");
                welcome.progressbar.setValue(i);
                if (i >= 0 && i <= 40) {
                    welcome.loadinglbl.setText("LOADING.....");
                }
                if (i > 40 && i <= 90) {
                    welcome.loadinglbl.setText("CONNECTING...");
                }
                if (i > 90 && i < 100) {
                    welcome.loadinglbl.setText("HI !!!");
                }
                if (i == 100) {
                    String[] okbutton = {"LOGIN", "SIGNUP", "CANCEL"};
                    ImageIcon icon = new ImageIcon("src/Images/smileresized.png");
                    int choice = JOptionPane.showOptionDialog(null, "                      WELCOME TO \n University Management System", "Welcome", JOptionPane.OK_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, icon, okbutton, 0);
                    switch (choice) {
                        case 0:
                            Login gui = new Login();
                            gui.setLocationRelativeTo(null); // This makes the window appears centered
                            gui.setVisible(true); // This shows the gui
                            
                            Registry r = LocateRegistry.getRegistry(1099);
                          
                            LoginController gui_controller = new LoginController(gui, r);
                            break;

                        case 1:
                            //  new SignUp().setVisible(true);
                            break;
                        case 2:
                            System.exit(0);
                        default:
                            break;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        welcome.dispose();
    }

    

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
welcome();
//new Login().setVisible(true);
////gui.getLoginbtn().addActionListener(new LoginController.getLoginbtn());
//  
//  }
//
//    public UniversityManagementSystemClient(Login gui) {
//        this.gui = gui;
//        String username = gui.getUsernametb().getText();
//            String password = gui.getPasswordtb().getText();
//              System.out.println("Hello11111111111111111111");
//
//            if (username.isEmpty() || password.isEmpty()) {
//                //JOptionPane.showMessageDialog(gui, "Fill All Fields");
//                System.out.println("Hello");
//            }else{
//                System.out.println("1111");
//         
//        }

    }

}
