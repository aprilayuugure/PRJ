package Model;

import java.sql.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingDB implements DatabaseInfo {
    public static Connection getConnect() 
    {
        try 
        {
            Class.forName(DRIVERNAME);
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("Error loading driver" + e);
        }
        try 
        {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            
            return con;
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static void insert(Booking b) {
        try (Connection con = getConnect()) 
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Bookings(UserID, MovieID, BookingDate, ShowTime, SeatCount, TotalAmount) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, b.getUserID());
            stmt.setInt(2, b.getMovieID());
            stmt.setDate(3, b.getBookingDate());
            stmt.setTime(4, b.getShowTime());
            stmt.setInt(5, b.getSeatCount());
            stmt.setDouble(6, b.getTotalAmount());
            
            stmt.executeUpdate(); con.close();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(BookingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Booking b) {
        try (Connection con = getConnect()) 
        {   
            PreparedStatement stmt = con.prepareStatement("UPDATE Bookings SET UserID = ?, MovieID = ?, BookingDate = ?, ShowTime = ?, SeatCount = ?, TotalAmount = ? WHERE ID = ?");
            
            stmt.setInt(1, b.getUserID());
            stmt.setInt(2, b.getMovieID());
            stmt.setDate(3, b.getBookingDate());
            stmt.setTime(4, b.getShowTime());
            stmt.setInt(5, b.getSeatCount());
            stmt.setDouble(6, b.getTotalAmount());
            stmt.setInt(7, b.getID());
            
            stmt.executeUpdate(); con.close();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(BookingDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }

    public static void delete(Booking b) {
        try (Connection con = getConnect()) 
        {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Bookings WHERE ID = ?");
            
            stmt.setInt(1, b.getID());
            
            stmt.executeUpdate(); con.close();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(BookingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Booking> search(Predicate<Booking> p) 
    {
        ArrayList<Booking> bookingList = listAll();
        ArrayList<Booking> res = new ArrayList<>();

        for (Booking b : bookingList)
        if (p.test(b)) res.add(b);

        return res;
    }

    public static ArrayList<Booking> listAll() {
        ArrayList<Booking> bookingList = new ArrayList<>();
        
        try (Connection con = getConnect()) 
        {
            PreparedStatement stmt = con.prepareStatement("SELECT ID, UserID, MovieID, BookingDate, ShowTime, SeatCount, TotalAmount FROM Bookings");
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) 
            {
                bookingList.add(new Booking(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getTime(5), rs.getInt(6), rs.getDouble(7)));
            }
            
            con.close(); return bookingList;
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(BookingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
