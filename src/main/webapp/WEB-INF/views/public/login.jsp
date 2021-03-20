<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>CatShow Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='<c:url value="/css/login.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-5">
                <div class="login-wrap p-4 p-md-5">
                    <div class="icon d-flex align-items-center justify-content-center">
                        <span class="fa fa-user-o"></span>
                    </div>
                    <h3 class="text-center mb-4">CatShowApp Admin</h3>
                    <form name='login' action="${pageContext.request.contextPath}/login" method='POST'
                          class="login-form">
                        <div class="form-group">
                            <label>
                                <input type="email" name="username" class="form-control rounded-left"
                                       placeholder="Email" required>
                            </label>
                        </div>
                        <div class="form-group d-flex">
                            <label>
                                <input type="password" name="password" class="form-control rounded-left"
                                       placeholder="Password" required>
                            </label>
                        </div>
                        <div class="form-group d-md-flex">
                            <div class="w-50">
                                <label class="checkbox-wrap checkbox-primary">Remember Me
                                    <input type="checkbox" checked>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="w-50 text-md-right">
                                <a href="#">Forgot Password</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary rounded submit p-3 px-5" value="Sign in"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>