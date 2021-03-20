<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="dashboard-menu.jsp" %>

<form:form method="post" modelAttribute="registerCatDto">
    <br>
    <br>
    <br>
    <table class="w3-table-all w3-third">
        <tbody>
        <tr>
            <th colspan="2">
                Register a Cat
            </th>
        </tr>
        <tr>
            <td>
                Name of the cat:
            </td>
            <td>
                <form:input path="cat.name"/>
            </td>
        </tr>
        <tr>
            <td>
                Cat's sex:
            </td>
            <td>
                <form:input path="cat.sex"/>
            </td>
        </tr>
        <tr>
            <td>
                Full EMS code:
            </td>
            <td>
                <form:input path="cat.ems"/>
            </td>
        </tr>
        <tr>
            <td>
                Classification:
            </td>
            <td>
                <form:input path="cat.classification"/>
            </td>
        </tr>
        <tr>
            <td>
                Pedigree number:
            </td>
            <td>
                <form:input path="cat.pedigree"/>
            </td>
        </tr>
        <tr>
            <td>
                Breeder:
            </td>
            <td>
                <form:input path="cat.breeder"/>
            </td>
        </tr>
        <tr>
            <td>
                Cat's mother:
            </td>
            <td>
                <form:input path="cat.mother"/>
            </td>
        </tr>
        <tr>
            <td>
                Cat's father:
            </td>
            <td>
                <form:input path="cat.father"/>
            </td>
        </tr>
            <%--        <tr>--%>
            <%--            <td>--%>
            <%--                Cat's date of birth:--%>
            <%--            </td>--%>
            <%--            <td>--%>
            <%--                <form:input type="date" path="cat.birthDate"/>--%>
            <%--            </td>--%>
            <%--        </tr>--%>
        <tr>
            <td>
                Exhibitor's first name:
            </td>
            <td>
                <form:input path="exhibitor.firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                Exhibitor's last name:
            </td>
            <td>
                <form:input path="exhibitor.lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                Exhibitor's email:
            </td>
            <td>
                <form:input path="exhibitor.email"/>
            </td>
        </tr>
        <tr>
            <td>
                Exhibitor's phone number:
            </td>
            <td>
                <form:input path="exhibitor.phone"/>
            </td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit">
            </th>
        </tr>
        </tbody>
    </table>
</form:form>

<%@ include file="dashboard-footer.jsp" %>
