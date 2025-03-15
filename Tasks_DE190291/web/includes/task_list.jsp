<%@page contentType="text/html" import="Model.*,java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task Assignment</title>
        <style>
            body { align-items: center; }
            table { width: 100%; border-collapse: collapse; }
            th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
            th { background-color: #f2f2f2; }
        </style>
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
