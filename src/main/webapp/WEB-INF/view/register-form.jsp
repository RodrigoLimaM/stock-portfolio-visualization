<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>--%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="/resources/css/register-form.css" rel="stylesheet" type="text/css" media="all" />
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
            <div class="register-form">
                <%--@elvariable id="userDTO" type="br.com.stockportfoliovisualization.model.UserDTO"--%>
                <form:form action="${s:mvcUrl('RC#registerUser').build()}" method="POST" modelAttribute="userDTO">
                    <div class="form-group">
                        <label class="col-sm-auto">Name</label>
                        <input required="true" name="name" type="text" class="form-control text-center"/>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-auto">E-mail</label>
                        <input required="true" name="email" type="email" class="form-control text-center"/>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-auto">Password</label>
                        <input required="true" name="password" type="password" class="form-control text-center"/>
                    </div>
                    <button type="submit" class="btn btn-success btn-lg btn-block">Sign Up</button>
                    <c:if test="${error ne null}">
                        ${error }
                    </c:if>
                </form:form>
            </div>
        </div>
    </body>
</html>