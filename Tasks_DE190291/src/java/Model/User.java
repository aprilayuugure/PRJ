package Model;
import java.io.*;
import java.sql.*;

public class User implements Serializable {
    private int userID;
    private String username;
    private String password;
    private String email;
    private Date registrationDate;
    
    public User(int userID, String username, String password, String email, Date registrationDate)
    {
        this.userID = userID; 
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
    }
    
    public User() {}
    
    public int getUserID() {
        return userID;
    }

    public void setID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
