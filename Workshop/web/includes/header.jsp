<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fruit Shop</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/main.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Fruit Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                
                <%
                    String name = (String)request.getAttribute("name");
                    
                    if (name == null) 
                    {
                %>
                    <li class = "nav-item">
                    <a class = "nav-link font-weight-bold bg-dark text-white" href = "login.jsp">Log in</a>
                    </li>
                <%
                    }
                    else 
                    {
                %>
                    <li class = "nav-item">
                        <a class = "nav-link" href = "login.jsp">Welcome, <%= name %></a>
                    </li>
                    
                    <li class = "nav-item">
                        <a class = "nav-link font-weight-bold bg-dark text-white" href = "login.jsp">Sign out</a>
                    </li>
                <%
                    }
                %>
            </ul>
        </div>
    </nav>

