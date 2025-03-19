package Model;

import java.sql.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieDB implements DatabaseInfo {
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
        catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static void insert(Movie m) {
        try (Connection con = getConnect()) 
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Movies(Title, Director, ReleaseDate, Duration, TicketPrice) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, m.getTitle());
            stmt.setString(2, m.getDirector());
            stmt.setDate(3, m.getReleaseDate());
            stmt.setInt(4, m.getDuration());
            stmt.setDouble(5, m.getTicketPrice());
            
            stmt.executeUpdate(); con.close();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(MovieDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Movie m) {
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE Movies SET Title = ?, Director = ?, ReleaseDate = ?, Duration = ?, TicketPrice = ? WHERE ID = ?");
            
            stmt.setString(1, m.getTitle());
            stmt.setString(2, m.getDirector());
            stmt.setDate(3, m.getReleaseDate());
            stmt.setInt(4, m.getDuration());
            stmt.setDouble(5, m.getTicketPrice());
            stmt.setInt(6, m.getID());
            
            stmt.executeUpdate(); con.close();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(MovieDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }

    public static void delete(Movie m) {
        try (Connection con = getConnect()) 
        {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Movies WHERE ID = ?");
            
            stmt.setInt(1, m.getID());
            
            stmt.executeUpdate(); con.close();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(MovieDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Movie> search(Predicate<Movie> p)
    {
        ArrayList<Movie> movieList = listAll();
        ArrayList<Movie> res = new ArrayList<Movie>();
        
        for(Movie m : movieList)
        if(p.test(m)) res.add(m);
            
        return res;
    }
    
    public static ArrayList<Movie> listAll() {
        ArrayList<Movie> movieList = new ArrayList<>();
        
        try (Connection con = getConnect()) 
        {
            PreparedStatement stmt = con.prepareStatement("SELECT ID, Title, Director, ReleaseDate, Duration, TicketPrice FROM Movies");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) 
            {
                movieList.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getDouble(6)));
            }
            
            con.close(); return movieList;
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(MovieDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
