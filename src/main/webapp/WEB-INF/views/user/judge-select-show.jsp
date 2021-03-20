<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="dashboard-menu.jsp" %>
<br>
<br>
<br>
<div class="w3-container">
    <table id="searchableTable" class="w3-table-all">
        <label for="tableInput">
            <input class="w3-input w3-animate-input" type="text" id="tableInput" onkeyup="searchTable()"
                   placeholder="Search . . .">
        </label>
        <tbody>
        <tr>
            <th colspan="12">ADD THE JUDGE TO AVAILABLE UPCOMING SHOW</th>
        </tr>
        <tr>
            <th></th>
            <th>ID</th>
            <th>DATE</th>
            <th>CITY</th>
            <th>COUNTRY</th>
            <th>NAME</th>
            <th>ORGANIZER</th>
            <th>CONCLUDED</th>
            <th>PUBLISHED</th>
            <th>JUDGES</th>
            <th>CONTESTANTS</th>
            <th></th>
        </tr>

        <c:forEach items="${upcomingAllShowDates}" var="upcoming">

            <tr>
                <td>
                    <form:form method="post" modelAttribute="showDates">
                        <form:hidden path="id" value="${upcoming.id}"/>
                        <input type="submit" value="Add"/>
                    </form:form>
                </td>
                <td>${upcoming.show.id}</td>
                <td>${upcoming.date}</td>
                <td>${upcoming.show.city}</td>
                <td>${upcoming.show.country}</td>
                <td>${upcoming.show.name}</td>
                <td>${upcoming.show.organizer}</td>
                <td>${upcoming.show.concluded}</td>
                <td>${upcoming.show.published}</td>
                <td>LINK</td>
                <td>LINK</td>
                <td>EDIT SHOW</td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</div>
<br>
<br>
<br>

<%@ include file="dashboard-footer.jsp" %>
