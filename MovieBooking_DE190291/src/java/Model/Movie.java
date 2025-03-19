package Model;
import java.io.*;
import java.sql.*;

public class Movie implements Serializable {
    private int ID;
    private String title;
    private String director;
    private Date releaseDate;
    private int duration;
    private double ticketPrice;
    
    public Movie(int ID, String title, String director, Date releaseDate, int duration, double ticketPrice) {
        this.ID = ID;
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
    }
    
    public Movie() {}
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}