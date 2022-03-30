<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/30/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Tính tiền nè</h1>

<form action="/calculator" method="get">
    <span><label for="number1">Number 1</label>
    <input type="text" id="number1" name="number1">
    <label for="number2">Number 2</label>
    <input type="text" id="number2" name="number2"></span>
    <br><br>
    <span>
        <button type="submit" value="Addition(+)" name="dau">Addition(+)</button>
        <button type="submit" value="Subtraction(-)" name="dau">Subtraction(-)</button>
        <button type="submit" value="Mutiplication(*)" name="dau">Mutiplication(*)</button>
        <button type="submit" value="Division(/)" name="dau">Division(/)</button>
    </span>
</form>
<p>Result : ${total}</p>
</body>
</html>
