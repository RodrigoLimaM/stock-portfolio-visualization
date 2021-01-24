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
                <a class="active" href="/">Minha Carteira de Ações</a>
            </div>
        </header>
        <div class="container total-center">
            <div class="register-form">
                <%--@elvariable id="userDTO" type="br.com.stockportfoliovisualization.model.UserDTO"--%>
                <form:form action="${s:mvcUrl('RC#registerUser').build()}" method="POST" modelAttribute="userDTO">
                    <div class="form-group">
                        <label class="col-sm-auto">Nome</label>
                        <input required="true" name="name" type="text" class="form-control text-center"/>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-auto">E-mail</label>
                        <input required="true" name="email" type="email" class="form-control text-center"/>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-auto">Senha</label>
                        <input required="true" name="password" type="password"
                               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
                               title="A senha deve conter ao menos 8 caracteres, uma letra maiúscula, uma letra minúscula e um caractere especial."
                               class="form-control text-center"/>
                    </div>
                    <button type="submit" class="btn btn-success btn-lg btn-block">Cadastrar</button>
                    <c:if test="${error ne null}">
                        ${error }
                    </c:if>
                </form:form>
            </div>
        </div>
    </body>
</html>