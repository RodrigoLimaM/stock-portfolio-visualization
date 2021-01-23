<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>--%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="/resources/css/login-form.css" rel="stylesheet" type="text/css" media="all" />
<script src="/resources/js/script.js"></script>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
    <body>
        <header>
            <div class="topnav">
                <a class="active" href="/">Your Stock Portfolio</a>
            </div>
        </header>
        <div class="container total-center">
            <div class="login-form">
                <form:form servletRelativeAction="/login" method="POST">
                    <div class="form-group">
                        <label class="col-sm-auto">E-mail</label>
                        <input name="username" type="text" class="form-control text-center"/>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-auto">Password</label>
                        <input name="password" type="password" class="form-control text-center"/>
                    </div>
                    <button type="submit" class="btn btn-success btn-lg btn-block">Sign In</button>
                </form:form>
                <form:form servletRelativeAction="/register" method="GET">
                    <button type="submit" class="btn btn-outline-success btn-lg btn-block">Sign Up</button>
                </form:form>
                <c:if test="${ param.error ne null}">
                    <div class="login-error">Invalid username/password</div>
                </c:if>
            </div>
        </div>
    </body>
</html>