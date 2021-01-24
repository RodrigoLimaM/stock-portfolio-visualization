<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>--%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="/resources/css/home.css" rel="stylesheet" type="text/css" media="all" />
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
            <a href="/logout">Sair</a>
        </div>
    </header>
        <div class="container total-center">
            <table class="table table-hover table-success text-white">
                <tr class="bg-success">
                    <th scope="col">Código</th>
                    <th scope="col">Preço de Compra</th>
                    <th scope="col">Quantidade</th>
                    <th scope="col">Preço de Compra Total</th>
                    <th scope="col">Preço Atual*</th>
                    <th scope="col">Preço Atual Total*</th>
                    <th scope="col">Taxas</th>
                    <th scope="col">Gasto Total</th>
                </tr>
                <c:forEach items="${userPortfolio.stockInfos }" var="stockInfo">
                    <tr class="bg-success">
                        <th scope="row">${stockInfo.stock }</th>
                        <td>${stockInfo.stockPurchaseValue }</td>
                        <td>${stockInfo.quantity }</td>
                        <td>${stockInfo.stockTotalPurchaseValue }</td>
                        <td>${stockInfo.currentStockValue }</td>
                        <td>${stockInfo.currentTotalStockValue }</td>
                        <td>${stockInfo.fees }</td>
                        <td>${stockInfo.totalSpentValue }</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>