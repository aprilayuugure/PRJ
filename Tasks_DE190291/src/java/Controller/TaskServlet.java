package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import Model.*;

@WebServlet(name = "TaskServlet", urlPatterns = {"/TaskServlet"})
public class TaskServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TaskServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TaskServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        ArrayList<Task> taskList = TaskDB.listAll();
        
        System.out.println(taskList);
        
        request.setAttribute("taskList", taskList);
        
        request.getRequestDispatcher("/includes/task_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
