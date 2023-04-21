package Entity;

import adt.DoublyLinkList;
import adt.DoublyLinkListInterface;
// Name : Cheok Jia Wei
// Student ID : 21WMR12521
public class VotingRecorder implements Comparable<VotingRecorder> {

    // To keep track on who voted for who
    private Voter voter;
    private Singer singer;
    private boolean isCounted;
    public static int totalVotes;

    public static DoublyLinkListInterface<DeleteHistory> historyList = new DoublyLinkList<DeleteHistory>();


    // Empty Constructor =======================================================================================================
    public VotingRecorder(){
        // Create dummy data for empty constructor
        this.voter = new Voter();
        this.singer = new Singer();
        this.isCounted = false;
        totalVotes++;
    }

    public VotingRecorder(Voter voter, Singer singer){
        this.voter = voter;
        this.singer = singer;
        this.isCounted = false;
        totalVotes++;
    }

    // Setter
    public void setVoter(Voter voter){
        this.voter = voter;
    }

    public void setSinger(Singer singer){
        this.singer = singer;
    }

    public void setIsCounted(boolean bool){
        this.isCounted = bool;
    }

    public static void setHistoryList(DoublyLinkListInterface<DeleteHistory> historyList) {
        VotingRecorder.historyList = historyList;
    }

    // ======================================================================================================================
    // Getter ===============================================================================================================
    public Voter getVoter(){
        return this.voter;
    }

    public Singer getSinger(){
        return this.singer;
    }

    public boolean getIsCounted(){
        return this.isCounted;
    }

    public int getTotalVotes(){
        return totalVotes;
    }

    public static DoublyLinkListInterface<DeleteHistory> getHistoryList() {
        return historyList;
    }

    // ======================================================================================================================


    public static void addVoteHistory(DeleteHistory v){
        historyList.add(v);
    }

    @Override
    public int compareTo(VotingRecorder o) {

        return 0;
    }

    @Override
    public String toString(){
        return "Voter : " + this.voter.getName() + " voted for : " + this.singer.getName() ;
    }

}
