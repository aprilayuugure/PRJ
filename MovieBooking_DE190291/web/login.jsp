<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <meta charset = "UTF-8">
    <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class = "d-flex vh-100 justify-content-center align-items-center bg-light">
    <div class = "container">
        <div class = "row justify-content-center">
            <div class = "col-md-4 bg-white p-4 rounded shadow">
                <h2 class = "text-primary text-center mb-4">Login</h2>
                <form action = "LoginServlet" method = "post">
                    <div class = "mb-3">
                        <label class = "form-label">Email:</label>
                        <input type = "text" name = "email" class = "form-control" placeholder = "Enter your email" required>
                    </div>
                    
                    <div class = "mb-3">
                        <label class = "form-label">Password:</label>
                        <input type = "password" name = "password" class = "form-control" placeholder = "Enter your password" required>
                    </div>
                    <button type = "submit" class = "btn btn-primary w-100">Login</button>
                </form>
            </div>
        </div>
    </div>
</body>
