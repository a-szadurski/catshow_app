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
            <th colspan="11">AVAILABLE JUDGES</th>
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
                        <button class="w3-button w3-border w3-padding-small">Select</button>
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
<br>
<br>
<br>

<%@ include file="dashboard-footer.jsp" %>
