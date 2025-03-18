package Model;

import java.sql.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TaskAssignmentDB implements DatabaseInfo{
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
    
    public static void insert(TaskAssignment ta)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO TaskAssignments(AssignmentID, TaskID, UserID, AssignedDate, CompleteDate) VALUES (?, ?, ?, ?, ?)");
            
            stmt.setInt(1, ta.getAssignmentID());
            stmt.setInt(2, ta.getTaskID());   
            stmt.setInt(3, ta.getUserID());    
            stmt.setDate(4, ta.getAssignedDate());
            stmt.setDate(5, ta.getCompleteDate());
            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(TaskAssignmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(TaskAssignment ta)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("UPDATE TaskAssignments SET TaskID = ?, UserID = ?, AssignedDate = ?, CompleteDate = ? WHERE AssignmentID = ?");
           
            stmt.setInt(1, ta.getTaskID());   
            stmt.setInt(2, ta.getUserID());    
            stmt.setDate(3, ta.getAssignedDate());
            stmt.setDate(4, ta.getCompleteDate());
            stmt.setInt(5, ta.getAssignmentID());
            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(TaskAssignmentDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
    
    public static void delete(TaskAssignment ta)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM TaskAssignments WHERE AssignmentID = ?");
            
            stmt.setInt(1, ta.getAssignmentID());
            
            stmt.executeUpdate(); con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(TaskDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<TaskAssignment> search(Predicate<TaskAssignment> p)
    {
        ArrayList<TaskAssignment> taskAssignmentList = listAll();
        ArrayList<TaskAssignment> res = new ArrayList<TaskAssignment>();
        
        for(TaskAssignment ta : taskAssignmentList)
        if(p.test(ta)) res.add(ta);
            
        return res;
    }
    
    public static ArrayList<TaskAssignment> listAll()
    {
        ArrayList<TaskAssignment> taskAssignmentList= new ArrayList<TaskAssignment>();
   
        try(Connection con = getConnect()) 
       {
            PreparedStatement stmt = con.prepareStatement("SELECT AssignmentID, TaskID, UserID, AssignedDate, CompleteDate FROM TaskAssignments");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                taskAssignmentList.add(new TaskAssignment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5)));
            }
            
            con.close(); return taskAssignmentList;
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(TaskAssignmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return null;
    }
}
