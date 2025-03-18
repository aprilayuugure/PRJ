<%@page contentType="text/html" import="Model.*,java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Task Assignment</title>
        <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
        <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
        <link rel = "stylesheet" href = "css/style.css">
    </head>
    
    <body>
        <h3>Task Assignment</h3>

        <div class="container">
            <table>
                <tr>
                    <th>Task ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Created Date</th>
                    <th>Due Date</th>
                    <th>Status</th>
                </tr>
                
                <c:forEach var="t" items="${taskList}">
                    <tr>
                        <td>${t.taskID}</td>
                        <td>${t.title}</td>
                        <td>${t.description}</td>
                        <td>${t.createdDate}</td>
                        <td>${t.dueDate}</td>
                        <td>${t.status}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
