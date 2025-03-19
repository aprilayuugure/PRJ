package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Model.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User u = UserDB.getUserByEmail(email);
        
        if (u == null)
        {
            request.setAttribute("error_message", "Account does not exist");
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else if (!password.equals(u.getPassword()))
        {
            request.setAttribute("error_message", "Wrong password");
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else
        { 
            HttpSession session = request.getSession();
            
            session.setAttribute("user", u);
            session.setAttribute("movieList", MovieDB.listAll());
            
            response.sendRedirect("index.jsp");
        }
    }
}