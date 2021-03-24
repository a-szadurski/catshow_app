<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dashboard-menu.jsp" %>
<br>
<br>
<br>
<div class="w3-container">
    <form:form method="post" modelAttribute="show">

        <table class="w3-table-all w3-third">
            <tbody>
            <tr>
                <th colspan="3">
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
                <td><form:errors path="city" cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <td>
                    Country:
                </td>
                <td>
                    <form:input path="country"/>
                </td>
                <td><form:errors path="country" cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <td>
                    Show's name:
                </td>
                <td>
                    <form:input path="name"/>
                </td>
                <td><form:errors path="name" cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <td>
                    Organizer:
                </td>
                <td>
                    <form:input path="organizer"/>
                </td>
                <td><form:errors path="organizer" cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <th colspan="3">
                    <input type="submit" value="Save & assign dates (next step)">
                </th>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>
<%@ include file="dashboard-footer.jsp" %>
