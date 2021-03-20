<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="dashboard-menu.jsp" %>
<div class="w3-container">
    <form:form method="post" modelAttribute="cat">
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
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    Cat's sex:
                </td>
                <td>
                    <form:input path="sex"/>
                </td>
            </tr>
            <tr>
                <td>
                    Full EMS code:
                </td>
                <td>
                    <form:input path="ems"/>
                </td>
            </tr>
            <tr>
                <td>
                    Pedigree number:
                </td>
                <td>
                    <form:input path="pedigree"/>
                </td>
            </tr>
            <tr>
                <td>
                    Breeder:
                </td>
                <td>
                    <form:input path="breeder"/>
                </td>
            </tr>
            <tr>
                <td>
                    Cat's mother:
                </td>
                <td>
                    <form:input path="mother"/>
                </td>
            </tr>
            <tr>
                <td>
                    Cat's father:
                </td>
                <td>
                    <form:input path="father"/>
                </td>
            </tr>
            <tr>
                <td>
                    Cat's date of birth:
                </td>
                <td>
                    <form:input type="date" path="birthDate"/>
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
            <th colspan="10">REGISTERED CATS (DESC)</th>
        </tr>
        <tr>
            <th></th>
            <th>Id</th>
            <th>Name</th>
            <th>Sex</th>
            <th>EMS</th>
            <th>Pedigree</th>
            <th>Breeder</th>
            <th>Mother</th>
            <th>Date of Birth</th>
            <th></th>
        </tr>
        <c:forEach items="${catsList}" var="catsList">

            <tr>
                <td>
                    <a href='<c:url value="${pageContext.request.contextPath}/user/cat/assign/show/${catsList.id}"/>'>
                        <button class="w3-button w3-border w3-padding-small">Assign to Show</button>
                    </a>

                </td>
                <td>${catsList.id}</td>
                <td>${catsList.name}</td>
                <td>${catsList.sex}</td>
                <td>${catsList.ems}</td>
                <td>${catsList.pedigree}</td>
                <td>${catsList.breeder}</td>
                <td>${catsList.mother}</td>
                <td>${catsList.father}</td>
                <td>${catsList.birthDate}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="dashboard-footer.jsp" %>
