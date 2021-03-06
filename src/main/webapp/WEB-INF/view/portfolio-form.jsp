<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="/resources/css/portfolio-form.css" rel="stylesheet" type="text/css" media="all" />
<script src="/resources/js/script.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <title>Your Stock Porftolio</title>
    </head>
    <body onload="appendRow()">
        <header>
            <div class="topnav">
                <a class="active" href="/">Minha Carteira de Ações</a>
                <a href="/logout">Sair</a>
            </div>
        </header>
        <div class="container total-center">
            <%--@elvariable id="stockInfo" type="br.com.stockportfoliovisualization.model.StockInfo"--%>
            <form:form servletRelativeAction="/portfolio" method="POST">
                <div class="stock-info-rows" id="stock-info-row">
                </div>
                <div class="add-row-button">
                    <button type="button" onclick="appendRow()" value="Add Row" class="btn btn-outline-success btn-lg btn-block">+1</button>
                </div>
                <button type="submit" class="btn btn-success btn-lg btn-block">Salvar</button>
            </form:form>
        </div>
    </body>
</html>