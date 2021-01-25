<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <div class="table-container">
            <div class="current-profit">
                Saldo atual: <fmt:formatNumber value="${userPortfolio.currentProfit }" type="currency" currencySymbol="R$"/>
            </div>
            <table class="table table-hover table-success text-white">
                <tr class="bg-success">
                    <th scope="col">Código</th>
                    <th scope="col">Preço de Compra</th>
                    <th scope="col">Quantidade</th>
                    <th scope="col">Preço de Compra Total</th>
                    <th scope="col">Taxas</th>
                    <th scope="col">Preço Atual*</th>
                    <th scope="col">Preço Atual Total*</th>
                    <th scope="col">Gasto Total</th>
                </tr>
                <c:forEach items="${userPortfolio.stockInfos }" var="stockInfo">
                    <tr class="bg-success">
                        <th scope="row">${stockInfo.stock }</th>
                        <td><fmt:formatNumber value="${stockInfo.stockPurchaseValue }" type="currency" currencySymbol="R$"/></td>
                        <td>${stockInfo.quantity }</td>
                        <td><fmt:formatNumber value="${stockInfo.stockTotalPurchaseValue }" type="currency" currencySymbol="R$"/></td>
                        <td><fmt:formatNumber value="${stockInfo.fees }" type="currency" currencySymbol="R$"/></td>
                        <td><fmt:formatNumber value="${stockInfo.currentStockValue }" type="currency" currencySymbol="R$"/></td>
                        <td><fmt:formatNumber value="${stockInfo.currentTotalStockValue }" type="currency" currencySymbol="R$"/></td>
                        <td><fmt:formatNumber value="${stockInfo.totalSpentValue }" type="currency" currencySymbol="R$"/></td>
                    </tr>
                </c:forEach>
                <tr class="bg-success">
                    <th scope="row">Totais</th>
                    <td><fmt:formatNumber value="${userPortfolio.totalStocksPurchaseValue }" type="currency" currencySymbol="R$"/></td>
                    <td>${userPortfolio.totalStocksQuantity }</td>
                    <td><fmt:formatNumber value="${userPortfolio.totalAllStocksPurchaseValue }" type="currency" currencySymbol="R$"/></td>
                    <td><fmt:formatNumber value="${userPortfolio.totalFees }" type="currency" currencySymbol="R$"/></td>
                    <td><fmt:formatNumber value="${userPortfolio.totalCurrentStockValue }" type="currency" currencySymbol="R$"/></td>
                    <td><fmt:formatNumber value="${userPortfolio.totalAllCurrentStockValue }" type="currency" currencySymbol="R$"/></td>
                    <td><fmt:formatNumber value="${userPortfolio.totalSpentValue }" type="currency" currencySymbol="R$"/></td>
                </tr>
            </table>
            <div class="warning-message">
                *Os preços atuais das ações podem ter delay de até uma hora
            </div>
            <div class="add-stock-button">
                <button href="/portfolio" type="button" class="btn btn-outline-success btn-lg btn-block">Adicionar</button>
            </div>
        </div>
    </body>
</html>