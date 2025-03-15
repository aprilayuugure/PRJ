package Model;
import java.io.*;
import java.sql.*;

public class TaskAssignment implements Serializable {
    private int assignmentID;
    private int taskID;
    private int userID;
    private Date assignedDate;
    private Date completeDate;
    
    public TaskAssignment(int assignmentID, int taskID, int userID, Date assignedDate, Date completeDate) 
    {
        this.assignmentID = assignmentID;
        this.taskID = taskID;
        this.userID = userID;
        this.assignedDate = assignedDate;
        this.completeDate = completeDate;
    }
    
    public TaskAssignment() {}   
    
    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
}
