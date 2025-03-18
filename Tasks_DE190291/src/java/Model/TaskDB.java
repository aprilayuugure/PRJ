package Model;

import java.sql.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TaskDB implements DatabaseInfo{
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
    
    public static void insert(Task t)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Tasks(TaskID, Title, Description, CreatedDate, DueDate, Status) VALUES (?, ?, ?, ?, ?, ?)");
            
            stmt.setInt(1, t.getTaskID());
            stmt.setString(2, t.getTitle());   
            stmt.setString(3, t.getDescription());    
            stmt.setDate(4, t.getCreatedDate());
            stmt.setDate(5, t.getDueDate());
            stmt.setString(6, t.getStatus());

            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(TaskDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(Task t)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("UPDATE Tasks SET Title = ?, Description = ?, CreatedDate = ?, DueDate = ?, Status = ? WHERE TaskID = ?");
           
            stmt.setString(1, t.getTitle());   
            stmt.setString(2, t.getDescription());    
            stmt.setDate(3, t.getCreatedDate());
            stmt.setDate(4, t.getDueDate());
            stmt.setString(5, t.getStatus());
            stmt.setInt(6, t.getTaskID());
            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(TaskDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
    
    public static void delete(Task t)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Tasks WHERE TaskID = ?");
            
            stmt.setInt(1, t.getTaskID());
            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(TaskDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Task> search(Predicate<Task> p)
    {
        ArrayList<Task> taskList = listAll();
        ArrayList<Task> res = new ArrayList<Task>();
        
        for(Task t : taskList)
        if(p.test(t)) res.add(t);
            
        return res;
    }
    
    public ArrayList<Task> listAll()
    {
        ArrayList<Task> taskList= new ArrayList<Task>();
   
        try(Connection con = getConnect()) 
       {
            PreparedStatement stmt = con.prepareStatement("SELECT TaskID, Title, Description, CreatedDate, DueDate, Status FROM Tasks");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                taskList.add(new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6)));
            }
            
            con.close(); return taskList;
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(TaskDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return null;
    }
            
}
