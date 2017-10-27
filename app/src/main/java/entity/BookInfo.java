package entity;

/**
 * Created by Administrator on 2017/10/26.
 */

public class BookInfo {
    private String bookname;
    private String pubilsher;
    private String time;
    private String place;
    private String author;
    private boolean isBorrow;

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPubilsher() {
        return pubilsher;
    }

    public void setPubilsher(String pubilsher) {
        this.pubilsher = pubilsher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
