<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <meta charset = "UTF-8">
    <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
    <link rel = "stylesheet" href = "css/style.css">
</head>
<body>
    <div class = "form-container">
        <h2>User Registration</h2>

        <form action = "RegisterServlet" method = "post">
            <div class = "form-group">
                <label>Username:</label>
                <input type = "text" name = "fullName" placeholder = "Enter username" required>
            </div>
            <div class = "form-group">
                <label>Email:</label>
                <input type = "email" name = "email" placeholder = "Enter email" required>
            </div>
            <div class = "form-group">
                <label>Password:</label>
                <input type = "password" name = "password" placeholder = "Enter password" required>
            </div>
            <input type = "submit" value = "Register" class = "btn">
        </form>
    </div>
</body>
</html>
