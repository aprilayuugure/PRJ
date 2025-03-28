<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <c:if test = "${not empty requestScope.name}">
        <table class = "table table-bordered table-striped table-hover text-center align-middle">
            <thead class = "table-primary">
                <tr>
                    <th>Customer ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Registration date</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var = "c" items = "${customerList}">
                    <tr>
                        <td>${c.customerId}</td>
                        <td>${c.firstName} ${c.lastName}</td>
                        <td>${c.email}</td>
                        <td>${c.password}</td>
                        <td>${c.address}</td>
                        <td>${c.phone}</td>
                        <td>${c.registrationDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>