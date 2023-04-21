package Entity;

import adt.AVLTree;
import adt.AVLTreeInterface;
// Author     : Boo Zheng Feng
// Student ID : 21WMR12518
public class Admin implements Comparable<Admin> {
    private String AdminID;
    private String password;
    private String AdminName;
    private AVLTreeInterface<Event> eventList ;

    public Admin() {
    }

    public Admin(String AdminID){
        this(AdminID, "", "");
    }

    public Admin(String AdminID, String password){
        this(AdminID, password, "");
    }

    public Admin(String adminID, String password, String adminName) {
        this.AdminID = adminID;
        this.password = password;
        this.AdminName = adminName;
        this.eventList = new AVLTree<>();
    }

    public String getAdminID() {
        return AdminID;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public AVLTreeInterface<Event> getEvenList() {
        return eventList;
    }

    public void setEvenList(AVLTreeInterface<Event> evenList) {
        this.eventList = evenList;
    }

    public void addEvent(Event event) {
        eventList.insert(event);
    }


    // Method of Entity
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + AdminID + '\'' +
                ", adminName='" + AdminName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Admin adminID) {
        return this.AdminID.compareTo(adminID.getAdminID());
    }


}
