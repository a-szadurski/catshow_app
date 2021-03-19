<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dashboard-menu.jsp" %>


<form:form method="post" modelAttribute="registerJudgeDto">
    <br>
    <br>
    <br>
    <table class="w3-table-all w3-third">
        <tbody>
        <tr>
            <th colspan="2">
                Register a Judge
            </th>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td>
                <form:input path="judge.email"/>
            </td>
        </tr>
        <tr>
            <td>
                First name:
            </td>
            <td>
                <form:input path="judge.firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                Last name:
            </td>
            <td>
                <form:input path="judge.lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                Category 01:
            </td>
            <td>
                <form:checkbox path="judge.category01"/>
            </td>
        </tr>
        <tr>
            <td>
                Category 02:
            </td>
            <td>
                <form:checkbox path="judge.category02"/>
            </td>
        </tr>
        <tr>
            <td>
                Category 03:
            </td>
            <td>
                <form:checkbox path="judge.category03"/>
            </td>
        </tr>
        <tr>
            <td>
                Category 04:
            </td>
            <td>
                <form:checkbox path="judge.category04"/>
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
