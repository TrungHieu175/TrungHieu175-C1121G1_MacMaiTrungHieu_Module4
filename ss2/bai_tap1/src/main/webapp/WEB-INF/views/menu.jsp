<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/30/2022
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Menu</title>
</head>
<body>
<h1>List Menu</h1>
<p>Your order : </p>
<c:forEach var="list" items="${list}">
    ${list}
</c:forEach>
</body>
</html>
