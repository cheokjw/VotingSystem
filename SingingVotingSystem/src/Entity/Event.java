package Entity;
// Author     : Boo Zheng Feng
// Student ID : 21WMR12518
public class Event implements Comparable<Event> {

    private String adminId;
    private String name;
    private String date;
    private String location;

    public Event() {
    }

    public Event(String adminId, String name, String date, String location) {
        this.adminId = adminId;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public Event(String name, String date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getAdminId() {
        return this.adminId;
    }

    @Override
    public int compareTo(Event otherEvent) {
        return this.date.compareTo(otherEvent.getDate());
    }
}
