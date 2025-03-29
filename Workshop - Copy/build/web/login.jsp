<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Servlet</title>
        <meta charset = "UTF-8">
        <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
    </head>
    
    <body>
        
        <form action = "LoginServlet" method = "post" style = "margin: 10px; padding: 10px">
                       Email: <input type = "text" name = "email" style = "margin-bottom: none"><br></br>
                       Password: <input type = "text" name = "password" style = "margin-bottom: none"><br></br>
                        <input type = "submit" value = "Login">
        </form>
        
        <%
            String error_message = (String)request.getAttribute("error_message");
            
            if (error_message != null)
            {
                out.write("<p style = 'color: red'>" + error_message + "</p>");
            }
        %>
    </body>
</html>
