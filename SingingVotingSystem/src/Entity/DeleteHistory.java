package Entity;
// Name : Cheok Jia Wei
// Student ID : 21WMR12521
public class DeleteHistory implements Comparable<DeleteHistory> {
    private String voterName;
    private String singerName;

    public DeleteHistory(String voterName, String singerName){
        this.voterName = voterName;
        this.singerName = singerName;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(DeleteHistory o) {
        return this.compareTo(o);
    }
}
