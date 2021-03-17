<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<title>CatShowApp Admin Panel</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    html, body, h1, h2, h3, h4, h5 {
        font-family: "Raleway", sans-serif
    }
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i
            class="fa fa-bars"></i> &nbsp;Menu
    </button>
    <span class="w3-bar-item w3-right">CatShowApp Administration</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
    <div class="w3-container w3-row">
        <div class="w3-col s8 w3-bar">
            <span>Welcome, <strong><sec:authentication property="principal.username" /></strong></span><br>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
            <sec:authorize access="isAuthenticated()">
                <form action="<c:url value="/logout"/>" method="post">
                    <input type="submit" value="Wyloguj">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </sec:authorize>
        </div>
    </div>
    <hr>
    <div class="w3-container">
        <h5>Dashboard</h5>
    </div>
    <div class="w3-bar-block">
        <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
           onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a>
        <a href='<c:url value="${pageContext.request.contextPath}/user/main"/>' class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-fw"></i>&nbsp; Shows Overview</a>
        <a href='<c:url value="${pageContext.request.contextPath}/user/register/cat"/>' class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-fw"></i>&nbsp; Register a Cat</a>
        <a href='<c:url value="${pageContext.request.contextPath}/user/register/judge"/>' class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-fw"></i>&nbsp; Register a Judge</a>
        <a href='<c:url value="${pageContext.request.contextPath}/user/register/show"/>' class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-fw"></i>&nbsp; Register a Show</a>
        <a href='<c:url value="${pageContext.request.contextPath}/user/contestants/judges/assign"/>' class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-fw"></i>&nbsp; Assign Cats to Judges</a>
        <a href='<c:url value="${pageContext.request.contextPath}/user/contestants/judges/view"/>' class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-fw"></i>&nbsp; View Judges' Assigned Cats</a>

        <a href='<c:url value="${pageContext.request.contextPath}/user/contestants/rate"/>' class="w3-bar-item w3-button w3-padding">
            <i class="fa fa-fw"></i>&nbsp; Rate Cats</a>
        <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
            <a href='<c:url value="${pageContext.request.contextPath}/admin/users/add"/>' class="w3-bar-item w3-button w3-padding">
                <i class="fa fa-fw"></i>&nbsp; Add Users</a>
            <a href='<c:url value="${pageContext.request.contextPath}/admin/users/add"/>' class="w3-bar-item w3-button w3-padding">
                <i class="fa fa-fw"></i>&nbsp; Edit Users</a>
        </sec:authorize>
<%--        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>&nbsp; Settings</a><br><br>--%>
    </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer"
     title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">
