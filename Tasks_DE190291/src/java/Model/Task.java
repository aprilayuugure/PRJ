package Model;
import java.io.*;
import java.sql.*;

public class Task implements Serializable {
    private int taskID;
    private String title;
    private String description;
    private Date createdDate;
    private Date dueDate;
    private String status;

    public Task(int taskID, String title, String description, Date createdDate, Date dueDate, String status) 
    {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
        this.status = status;
    }
    
    public Task() {}
    
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    @Override
    public String toString() {
        return "Task{" + "taskID=" + taskID + ", title=" + title + ", description=" + description + ", createdDate=" + createdDate + ", dueDate=" + dueDate + ", status=" + status + '}';
    }
}
