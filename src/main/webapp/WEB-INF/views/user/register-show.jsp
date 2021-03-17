<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dashboard-menu.jsp" %>


<form:form method="post" modelAttribute="show">
    <br>
    <br>
    <br>
    <table class="w3-table-all w3-third">
        <tbody>
        <tr>
            <th colspan="2">
                Register a Show
            </th>
        </tr>
        <tr>
            <td>
                City:
            </td>
            <td>
                <form:input path="city"/>
            </td>
        </tr>
        <tr>
            <td>
                Country:
            </td>
            <td>
                <form:input path="country"/>
            </td>
        </tr>
        <tr>
            <td>
                Show's name:
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                Organizer:
            </td>
            <td>
                <form:input path="organizer"/>
            </td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="Save & assign dates (next step)">
            </th>
        </tr>
        </tbody>
    </table>
</form:form>

<%@ include file="dashboard-footer.jsp" %>
