<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 4/1/2022
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/view" method="post" modelAttribute="mail">

    <label for="languages"><strong>Languages :</strong></label>
    <form:select id="languages" name="languages" path="language">
        <option value="english">English</option>
        <option value="vietnamese">Vietnamese</option>
        <option value="japanese">Japanese</option>
        <option value="chinese">Chinese</option>
    </form:select><br><br>

    <label for="size"><strong>Page Size :</strong></label>
    <span>Show
    <form:select id="size" name="size" path="pageSize">
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="15">15</option>
        <option value="20">20</option>
        <option value="25">25</option>
        <option value="50">50</option>
        <option value="100">100</option>
    </form:select> emails per page</span><br><br>

    <label for="fillter"><strong>Spams fillter :</strong></label>
    <form:checkbox id="fillter" name="fillter" path="spamsFillter" value="1"/>
    <label for="fillter"> Enable spam fillter</label><br><br>

    <label for="signature"><strong>Signature :</strong></label>
    <form:textarea name="signature" rows="10" cols="30" id="signature" path="signature"/><br><br>

    <input type="submit" value="Update">
    <a href="/view">Cancel</a>
</form:form>
</body>
</html>
