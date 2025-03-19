<h3 class="text-center mt-4">Movies</h3>

<div class="container mt-3">
    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover text-center align-middle">
            <thead class="table-primary">
                <tr>
                    <th>Movie ID</th>
                    <th>Title</th>
                    <th>Director</th>
                    <th>Release Date</th>
                    <th>Duration</th>
                    <th>Ticket price</th>
                    <c:choose>
                        <c:when test = "${not empty sessionScope.user.ID}">
                            <th></th>
                        </c:when>
                    </c:choose>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="m" items="${movieList}">
                    <tr>
                        <td>${m.ID}</td>
                        <td>${m.title}</td>
                        <td>${m.director}</td>
                        <td>${m.releaseDate}</td>
                        <td>${m.duration}</td>
                        <td>${m.ticketPrice}</td>
                        <c:choose>
                            <c:when test = "${not empty sessionScope.user.ID}">
                                <td>
                                    <form action="BookingServlet" id = "bookingForm${m.ID}" method = "post">
                                        <input type ="hidden" name = "movieID" value = "${m.ID}">
                                        <input type ="hidden" name = "ticketPrice" value = "${m.ticketPrice}">
                                        <input type = "hidden" name = "seatCount" value = "">
                                        <button type = "submit" onclick = "booking(${m.ID})" class="btn btn-primary w-100">Book</button>
                                    </form>
                                </td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>                                          
</body>
