<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset = "UTF-8">
    <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
    <link rel = "stylesheet" href = "css/style.css">
</head>

<body>
    <div class = "form-container">
        <h2>Login</h2>
        <form action = "LoginServlet" method = "post">
            <div class = "form-group">
                <label>Email:</label>
                <input type = "text" name = "email" placeholder = "Enter your email" required>
            </div>
            <div class = "form-group">
                <label>Password:</label>
                <input type = "password" name = "password" placeholder = "Enter your password" required>
            </div>
            <input type = "submit" value = "Login" class = "btn">
        </form>

        <a href="register.jsp" >Register here</a>

        <c:if test = "${not empty error_message}">
            <p style = "color: red; text-align: center;">${error_message}</p>
        </c:if>
    </div>
</body>
</html>