package sg.edu.rp.c347.p05ndpsongs;

import java.io.Serializable;

/**
 * Created by 15035634 on 18/5/2017.
 */

public class Songs implements Serializable {

    private  int id;
    private String songTitle;
    private String singers;
    private int year;
    private int star;

    public Songs(int id, String songTitle, String singers, int year, int star) {
        this.songTitle = songTitle;
        this.singers = singers;
        this.year = year;
        this.id = id;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStar() {
        return star;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSongtitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStar(int star) {
        this.star = star;
    }


}

