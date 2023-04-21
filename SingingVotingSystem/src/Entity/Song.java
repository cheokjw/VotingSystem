package Entity;
// Name : Tan Jun Keat
// ID   : 21WMR12547
public class Song {

    private String songID;
    private String titles;
    private String category;
    private String produceBy;

    public Song(String songID, String titles, String category, String produceBy) {
        this.songID = songID;
        this.titles = titles;
        this.category = category;
        this.produceBy = produceBy;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduceBy() {
        return produceBy;
    }

    public void setProduceBy(String produceBy) {
        this.produceBy = produceBy;
    }

    public String getSongID() {
        return songID;
    }

    public void setSongID(String songID) {
        this.songID = songID;
    }
}
