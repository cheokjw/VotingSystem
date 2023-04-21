package Client;

import Entity.*;
import adt.*;

import java.util.Scanner;
// Author     : Boo Zheng Feng
// Student ID : 21WMR12518
public class Administrator {

    Scanner sc = new Scanner(System.in);

    private static AVLTreeInterface<Admin> adminList = new AVLTree<>();

    private static AVLTreeInterface<Admin> eventList = new AVLTree<>();

    public Admin login( AVLTreeInterface<Admin> adminList){

        Admin foundAdmin = null;
        do{
            System.out.println("\nPlease enter your admin id:");
            String adminID = sc.nextLine();

            System.out.println("Please enter your password:");
            String password = sc.nextLine();

            // verify identity of voter
            AVLTree.List<Admin> adminLt = adminList.inOrderTraversal();
            for(int i = 0; i < adminLt.size(); i++) {
                String pass = adminLt.get(i).getPassword();
                if(adminLt.get(i).getAdminID().compareTo(adminID) == 0 && password.equals(pass)) {
                    foundAdmin = adminLt.get(i);
                    break;
                }
            }

            if (foundAdmin != null) {
                System.out.println("Welcome " + foundAdmin.getAdminName() + "!");
            } else {
                System.out.println("Invalid Admin ID or password!");
                break;
            }
        }while(foundAdmin == null);

        return foundAdmin;
    }


    public void displayAdminEvents(AVLTreeInterface<Admin> adminList) {
        AVLTree.List<Admin> admins = adminList.inOrderTraversal();
        for (int i = 0; i < admins.size(); i++) {
            Admin admin = admins.get(i);
            System.out.println("Admin " + admin.getAdminName() + " events:");
            AVLTreeInterface<Event> events = admin.getEvenList();
            AVLTree.List<Event> eventList = events.inOrderTraversal();
            for (int j = 0; j < eventList.size(); j++) {
                Event event = eventList.get(j);
                System.out.printf("- %s on %s at %s%n",
                        event.getName(),
                        event.getDate(),
                        event.getLocation());
            }
            System.out.println(); // Print an empty line for formatting
        }
    }




    public void displayAdmin(AVLTreeInterface<Admin> adminList) {
        System.out.println("========================================");
        System.out.println("|             Admin List                |");
        System.out.println("========================================");

        // Display all admins in the adminList
        AVLTree.List<Admin> admin = adminList.inOrderTraversal();
        for (int i = 0; i < admin.size(); i++) {
            String formattedStr = String.format("| %-2d. %-20s %-8s |", i, admin.get(i).getAdminName(), admin.get(i).getAdminID());
            System.out.println(formattedStr);
        }

        System.out.println("========================================\n");
    }

    public void addAdmin(AVLTreeInterface<Admin> adminList) {
        // Add the admin to the adminList if it does not already exist
        System.out.println("Enter Admin ID: ");
        String id = sc.nextLine();

        System.out.println("Enter Admin Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        Admin admin = new Admin (id, password, name);

        try {
            adminList.insert(admin);
            System.out.println("Successfully added !");

        } catch (AVLTree.DuplicateElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAdmin(AVLTreeInterface<Admin> adminList) {
        // Remove the admin from the adminList if it exists

        boolean found = false;
        System.out.println("Enter Admin ID : ");
        String adminRmv = sc.nextLine();

        AVLTree.List<Admin> adminRemoveList = adminList.inOrderTraversal();
        for (int i = 0; i < adminRemoveList.size(); i ++) {

            if (adminRmv.equals(adminRemoveList.get(i).getAdminID())) {
                Admin adminToDelete = new Admin(adminRmv, "", "");
                adminList.remove(adminToDelete);
                System.out.println("Removed successfully !!!");
                found = true;
            }
        }
        if(!found){
            System.out.println("Admin not found !!!");
        }

    }

    public void searchAdmin(AVLTreeInterface<Admin> adminList) {
        System.out.println("Enter Admin ID: ");
        String adminID = sc.nextLine();

        boolean found = adminList.search(new Admin(adminID, "", ""));
        if (found) {
            AVLTree.List<Admin> adminLt = adminList.inOrderTraversal();
            for(int i = 0; i < adminLt.size(); i++) {
                if(adminLt.get(i).getAdminID().compareTo(adminID) == 0) {
                    Admin admin = adminLt.get(i);
                    System.out.println("Admin " + admin.getAdminName() + " events:");
                    AVLTreeInterface<Event> events = admin.getEvenList();
                    AVLTree.List<Event> eventList = events.inOrderTraversal();
                    for (int j = 0; j < eventList.size(); j++) {
                        Event event = eventList.get(j);
                        System.out.printf("- %s on %s at %s%n",
                                event.getName(),
                                event.getDate(),
                                event.getLocation());
                    }
                    System.out.println(); // Print an empty line for formatting
                    return;
                }
            }
        } else {
            System.out.println("Admin not found.");
        }
    }

}
