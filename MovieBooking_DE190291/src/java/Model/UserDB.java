package Model;

import java.sql.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDB implements DatabaseInfo{
    public static Connection getConnect(){
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
        catch(SQLException e) 
        {
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public static User getUserByEmail(String email)
    {
        User u = null;
        
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("SELECT ID, Username, Password FROM Users WHERE Email = ?");
            
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), email);
            }
            
            con.close();
            
            return u;
        }
        catch (Exception ex)
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void insert(User u)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Users(Username, Password, Email) VALUES (?, ?, ?, ?)");
            
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getEmail());   
            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(User u)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("UPDATE Users SET Username = ?, Password = ?, Email = ? WHERE ID = ?");
            
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPassword());   
            stmt.setString(3, u.getEmail());
            stmt.setInt(4, u.getID());
            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
    
    public static void delete(User u)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Users WHERE ID = ?");
            
            stmt.setInt(1, u.getID());
            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<User> search(Predicate<User> p)
    {
        ArrayList<User> userList = listAll();
        ArrayList<User> res = new ArrayList<User>();
        
        for(User u : userList)
        if(p.test(u)) res.add(u);
            
        return res;
    }
    
    public static ArrayList<User> listAll()
    {
        ArrayList<User> userList= new ArrayList<User>();
   
        try(Connection con = getConnect()) 
       {
            PreparedStatement stmt = con.prepareStatement("SELECT ID, Username, Password, Email, RegistrationDate FROM Users");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            
            con.close(); return userList;
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return null;
    }
}
