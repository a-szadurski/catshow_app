<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dashboard-menu.jsp" %>

<br>
<br>
<br>
<div class="w3-container">
    <table class="w3-table-all">
        <tbody>
        <tr>
            <th colspan="7">
                Show saved in previous step:
            </th>
        </tr>
        <tr>
            <th>ID</th>
            <th>CITY</th>
            <th>COUNTRY</th>
            <th>NAME</th>
            <th>ORGANIZER</th>
            <th>CONCLUDED</th>
            <th>PUBLISHED</th>
        </tr>
        <tr>
            <td>
                ${show.id}
            </td>
            <td>
                ${show.city}
            </td>
            <td>
                ${show.country}
            </td>
            <td>
                ${show.name}
            </td>
            <td>
                ${show.organizer}
            </td>
            <td>
                ${show.concluded}
            </td>
            <td>
                ${show.published}
            </td>
        </tr>
        <tr>
            <th colspan="2">
                Assigned dates: ${dateSum}
            </th>
            <th colspan="5">
                <form:form method="post" modelAttribute="dateToAdd">
                    <form:input path="date" type="date"/>
                    <form:hidden path="id" value="${showId}"/>
                    <input type="submit" value="Assign date">
                </form:form>
            </th>
        </tr>
        <c:forEach items="${dates}" var="date">
            <tr>
                <td>
                        ${date.date}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<br>
<br>

<%@ include file="dashboard-footer.jsp" %>
