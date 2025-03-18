<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset = "UTF-8">
    <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
    <title>Task Assignment</title>
    <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <nav class = "navbar navbar-expand-lg navbar-light bg-light">
        <a class = "navbar-brand" href = "#"></a>
        <button class = "navbar-toggler" type = "button" data-toggle = "collapse" data-target = "#navbarNav" aria-controls = "navbarNav" aria-expanded = "false" aria-label = "Toggle navigation">
            <span class = "navbar-toggler-icon"></span>
        </button>
        <div class = "collapse navbar-collapse" id = "navbarNav">
            <ul class = "navbar-nav ml-auto">
                <li class = "nav-item active">
                    <a class = "nav-link" href = "#">Home</a>
                </li>
           
                <c:choose>
                    <c:when test = "${empty sessionScope.user}">
                        <li class = "nav-item">
                            <a class = "nav-link font-weight-bold bg-dark text-white" href = "login.jsp">Log in</a>
                        </li>
                    </c:when>

                    <c:otherwise>
                        <span class = "nav-link text-white">Welcome, ${sessionScope.user.username}</span>

                        <li class = "nav-item">
                            <a class = "nav-link font-weight-bold bg-dark text-white" href = "login.jsp">Sign out</a>
                        </li>
                    </c:otherwise>   
                </c:choose>
            </ul>
        </div>
    </nav>
</body>
