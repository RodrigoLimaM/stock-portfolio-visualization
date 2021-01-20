<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>--%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="/resources/js/script.js"></script>

<!DOCTYPE html>
<html>
    <script></script>
    <head>
        <title>Home</title>
    </head>
    <body>
        <header>

        </header>
        <div class="container">
            <%--@elvariable id="stockInfo" type="br.com.stockportfoliovisualization.model.StockInfo"--%>
            <form:form servletRelativeAction="/portfolio" method="GET">
                <div class="stock-info-row">
                    <div id="first-row">
                        <div class="stock-info-row-item">
                            <label class="col-sm-auto">Stock Symbol</label>
                            <input type='text' name='stock' class='form-control text-center'>

                            <label class="col-sm-auto">Quantity</label>
                            <input type='text' name='quantity' class='form-control text-center'>

                            <label class="col-sm-auto">Brokerage Fees</label>
                            <input type='text' name='fees' class='form-control text-center'>
                        </div>
                    </div>
                </div>
                <div class="add-row-button">
                    <button type="button" onclick="appendRow()" value="Add Row" class="btn btn-success btn-lg btn-block">Add stock</button>
                </div>
                <button type="submit" class="btn btn-success btn-lg btn-block">Next</button>
            </form:form>
        </div>
    </body>
</html>