<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test = "${not empty requestScope.name}">
    <table border="2">
        <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </thead
        <tbody>

        </tbody>
        <p><%= request.getAttribute("customerList") %></p>
    </table>
</c:if>