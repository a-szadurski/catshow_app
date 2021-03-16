<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dashboard-menu.jsp" %>

<form:form method="post" modelAttribute="registerCatCmd">
    <br>
    <br>
    <br>
    <br>
    Name of the cat: <form:input path="cat.name"/>
    <br>
    Cat's sex: <form:input path="cat.sex"/>
    <br>
    Full EMS code: <form:input path="cat.ems"/>
    <br>
    Classification: <form:input path="cat.classification"/>
    <br>
    Pedigree number: <form:input path="cat.pedigree"/>
    <br>
    Breeder: <form:input path="cat.breeder"/>
    <br>
    Cat's mother: <form:input path="cat.mother"/>
    <br>
    Cat's father: <form:input path="cat.father"/>
    <br>
<%--    Cat's date of birth: <form:input type="date" path="cat.birthDate"/>--%>
    <br>
    Exhibitor's first name: <form:input path="exhibitor.firstName"/>
    <br>
    Exhibitor's last name: <form:input path="exhibitor.lastName"/>
    <br>
    Exhibitor's email: <form:input path="exhibitor.email"/>
    <br>
    Exhibitor's phone number: <form:input path="exhibitor.phone"/>
    <br>
    <br>
    <input type="submit">
</form:form>

<%@ include file="dashboard-footer.jsp" %>
