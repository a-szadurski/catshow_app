<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="dashboard-menu.jsp" %>

<div class="w3-container">
    <form:form method="post" modelAttribute="judge">
        <br>
        <br>
        <br>
        <table class="w3-table-all w3-third">
            <tbody>
            <tr>
                <th colspan="3">
                    Register a Judge
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
                    Category 01:
                </td>
                <td>
                    <form:checkbox path="category01" cssClass="w3-check"/>
                </td>
                <td><form:errors cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <td>
                    Category 02:
                </td>
                <td>
                    <form:checkbox path="category02" cssClass="w3-check"/>
                </td>
                <td><form:errors cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <td>
                    Category 03:
                </td>
                <td>
                    <form:checkbox path="category03" cssClass="w3-check"/>
                </td>
                <td><form:errors cssClass="w3-text-red"/></td>
            </tr>
            <tr>
                <td>
                    Category 04:
                </td>
                <td>
                    <form:checkbox path="category04" cssClass="w3-check"/>
                </td>
                <td><form:errors cssClass="w3-text-red"/></td>
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
            <th colspan="11">REGISTERED JUDGES (DESC)</th>
        </tr>
        <tr>
            <th></th>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Category 01</th>
            <th>Category 02</th>
            <th>Category 03</th>
            <th>Category 04</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${judgesList}" var="judgesList">

            <tr>
                <td>
                    <a href='<c:url value="${pageContext.request.contextPath}/user/judge/assign/show/${judgesList.id}"/>'>
                        <button class="w3-button w3-border w3-padding-small">Assign to Show</button>
                    </a>

                </td>
                <td>${judgesList.id}</td>
                <td>${judgesList.firstName}</td>
                <td>${judgesList.lastName}</td>
                <td><span>${judgesList.category01}</span></td>
                <td><span>${judgesList.category02}</span></td>
                <td><span>${judgesList.category03}</span></td>
                <td><span>${judgesList.category04}</span></td>
                <td>${judgesList.email}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="dashboard-footer.jsp" %>
