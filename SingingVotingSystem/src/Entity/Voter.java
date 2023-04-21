package Entity;

// Name : Ong Tzi Min
// Student ID : 21WMR12541
import adt.DoublyLinkList;
import adt.DoublyLinkListInterface;

public class Voter implements Comparable<Voter> {

    private String name;
    private String password;
    private String studentID;
    boolean isVote;

    private DoublyLinkListInterface<VotingHistory> voteHistoryList = new DoublyLinkList<>();

    // constructor
    public Voter(){

    }
    public Voter(String name, String password, String studentID) {
        this.name = name;
        this.password = password;
        this.studentID = studentID;
        this.isVote = false;
    }


    // setter and getter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String ic) {
        this.studentID = studentID;
    }

    public boolean getVote() {
        return isVote;
    }

    public void setVote(boolean vote) {
        this.isVote = true;
    }

    public DoublyLinkListInterface<VotingHistory> getVoteHistoryList() {
        return voteHistoryList;
    }

    public void setVoteHistoryList(DoublyLinkListInterface<VotingHistory> voteHistoryList) {
        this.voteHistoryList = voteHistoryList;
    }

    public void addVoteHistory(VotingHistory voteHistory){
        this.voteHistoryList.add(voteHistory);
    }

    // compare studentid of 2 voter object and return int indicate their relative ordering
    // this.studentid < o.studentid = -ve; if they are equal return 0, ; this.studentid > o.studentid returns +ve
    @Override
    public int compareTo(Voter o) {
        return studentID.compareTo(o.studentID);
    }

    @Override
    public String toString(){
        String string1 = "Voter{"+ "Name = " + name + "Student ID = "+ studentID;
        if (isVote){
            return  string1 + "is Vote = Yes";
        }else{
            return  string1 + "is Vote = No";
        }

    }


}
