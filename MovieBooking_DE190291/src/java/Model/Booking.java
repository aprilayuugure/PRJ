package Model;
import java.io.*;
import java.sql.*;

public class Booking implements Serializable {
    private int ID;
    private int userID;
    private int movieID;
    private Date bookingDate;
    private Time showTime;
    private int seatCount;
    private double totalAmount;
    
    public Booking(int ID, int userID, int movieID, Date bookingDate, Time showTime, int seatCount, double totalAmount) {
        this.ID = ID;
        this.userID = userID;
        this.movieID = movieID;
        this.bookingDate = bookingDate;
        this.showTime = showTime;
        this.seatCount = seatCount;
        this.totalAmount = totalAmount;
    }
    
    public Booking() {}
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Time getShowTime() {
        return showTime;
    }

    public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}