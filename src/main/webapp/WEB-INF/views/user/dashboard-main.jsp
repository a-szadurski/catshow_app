<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dashboard-menu.jsp" %>
<br>
<br>
<br>
<table class="w3-table-all">
    <tbody>
    <tr>
        <th>UPCOMING SHOWS</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>CITY</th>
        <th>COUNTRY</th>
        <th>NAME</th>
        <th>ORGANIZER</th>
        <th>CONCLUDED</th>
        <th>PUBLISHED</th>
        <th>DATE</th>
        <th>JUDGES</th>
        <th>CONTESTANTS</th>
    </tr>
    <c:forEach items="${upcomingAllShowDates}" var="upcoming">
    <tr>
        <td>${upcoming.show.id}</td>
        <td>${upcoming.show.city}</td>
        <td>${upcoming.show.country}</td>
        <td>${upcoming.show.name}</td>
        <td>${upcoming.show.organizer}</td>
        <td>${upcoming.show.concluded}</td>
        <td>${upcoming.show.published}</td>
        <td>${upcoming.date}</td>
        <td>LINK</td>
        <td>LINK</td>
        <td>EDIT SHOW</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<br>
<table class="w3-table-all">
    <tbody>
    <tr>
        <th>PAST SHOWS</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>CITY</th>
        <th>COUNTRY</th>
        <th>NAME</th>
        <th>ORGANIZER</th>
        <th>CONCLUDED</th>
        <th>PUBLISHED</th>
        <th>DATE</th>
        <th>JUDGES</th>
        <th>CONTESTANTS</th>
    </tr>
    <c:forEach items="${pastAllShowDates}" var="past">
        <tr>
            <td>${past.show.id}</td>
            <td>${past.show.city}</td>
            <td>${past.show.country}</td>
            <td>${past.show.name}</td>
            <td>${past.show.organizer}</td>
            <td>${past.show.concluded}</td>
            <td>${past.show.published}</td>
            <td>${past.date}</td>
            <td>LINK</td>
            <td>LINK</td>
            <td>EDIT SHOW</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="dashboard-footer.jsp" %>
