package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.time.*;
import java.util.*;
import Model.*;

@WebServlet(name = "BookingServlet", urlPatterns = {"/BookingServlet"})
public class BookingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("user");
        int userID = u.getID();
        int movieID = Integer.parseInt(request.getParameter("movieID"));
        java.sql.Date bookingDate = java.sql.Date.valueOf(LocalDate.now());
        java.sql.Time showTime = java.sql.Time.valueOf(LocalTime.of(new Random().nextInt(24), new Random().nextInt(60)));
        int seatCount = Integer.parseInt(request.getParameter("seatCount"));
        double totalAmount = seatCount * Double.parseDouble(request.getParameter("ticketPrice"));
        
        BookingDB.insert(new Booking(0, userID, movieID, bookingDate, showTime, seatCount, totalAmount));
        
        response.sendRedirect("index.jsp");
    }
}