<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/user/dashboard-menu.jsp" %>

<div class="w3-container">
    <form:form method="post" modelAttribute="user">
        <br>
        <br>
        <br>
        <table class="w3-table-all w3-third">
            <tbody>
            <tr>
                <th colspan="3">
                    Register a User
                </th>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td>
                    <form:input path="email"/>
                </td>
                <td><form:errors path="email" cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <td>
                    First name:
                </td>
                <td>
                    <form:input path="firstName"/>
                </td>
                <td><form:errors path="firstName" cssClass="w3-text-red"/></td>

            </tr>
            <tr>
                <td>
                    Last name:
                </td>
                <td>
                    <form:input path="lastName"/>
                </td>
                <td><form:errors path="lastName" cssClass="w3-text-red"/></td>

            </tr>
            <tr>
                <td>
                    Password:
                </td>
                <td>
                    <form:password path="password"/>
                </td>
                <td><form:errors path="password" cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <td>
                    Confirm password:
                </td>
                <td>
                    <form:password path="matchingPassword"/>
                </td>
                <td><form:errors path="matchingPassword" cssClass="w3-text-red"/></td>

            </tr>
            <tr>
                <th colspan="3">
                    <input type="submit" value="Save">
                </th>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>

<div class="w3-container">
    <br>
    <br>
    <br>
    <table id="searchableTable" class="w3-table-all">
        <label for="tableInput">
            <input class="w3-input w3-animate-input" type="text" id="tableInput" onkeyup="searchTable()"
                   placeholder="Search . . .">
        </label>
        <tbody>
        <tr>
            <th colspan="11">REGISTERED USERS (DESC)</th>
        </tr>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Enabled</th>
            <th>Role</th>
            <th></th>
        </tr>
        <c:forEach items="${usersList}" var="usersList">

            <tr>
                <td>${usersList.id}</td>
                <td>${usersList.firstName}</td>
                <td>${usersList.lastName}</td>
                <td>${usersList.email}</td>
                <td>${usersList.enabled}</td>
                <td><c:forEach items="${usersList.roles}" var="roles">${roles.name}</c:forEach></td>
                <td>
                    <a href='<c:url value="${pageContext.request.contextPath}/admin/user/edit/${usersList.id}"/>'>
                        <button class="w3-button w3-border w3-padding-small">Edit</button>
                    </a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/user/dashboard-footer.jsp" %>
