package Entity;
// Name : Ong Tzi Min
// Student ID : 21WMR12541
public class VotingHistory implements Comparable<VotingHistory> {

    private String singerVoted;

    public VotingHistory(String singerVoted){
        this.singerVoted = singerVoted;
    }

    public String getSingerVoted() {
        return singerVoted;
    }

    public void setSingerVoted(String singerVoted) {
        this.singerVoted = singerVoted;
    }

    @Override
    public int compareTo(VotingHistory o) {
        return this.compareTo(o);
    }

    @Override
    public String toString() {
        return "You have voted for " + getSingerVoted() ;
    }
}
