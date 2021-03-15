<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dashboard-menu.jsp" %>

<form:form method="post" modelAttribute="cat">
    <br>
    <br>
    <br>
    <br>
    Name of the cat:
    <form:input path="name"/>
    <br>
    Cat's sex:
    <form:input path="sex"/>
    <br>
    Full EMS code:
    <form:input path="ems"/>
    <br>
    Classification:
    <form:input path="classification"/>
    <br>
    Pedigree number:
    <form:input path="pedigree"/>
    <br>
    Breeder:
    <form:input path="breeder"/>
    <br>
    Cat's mother:
    <form:input path="mother"/>
    <br>
    Cat's father:
    <form:input path="father"/>
    <br>
    Cat's date of birth:
    <form:input path="birthDate"/>
    <br>
    <br>
    <br>
</form:form>

<%@ include file="dashboard-footer.jsp" %>
