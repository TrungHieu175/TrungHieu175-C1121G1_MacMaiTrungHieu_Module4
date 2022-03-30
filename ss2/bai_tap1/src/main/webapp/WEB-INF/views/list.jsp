<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/30/2022
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Sandwich Comdiments</h1>

<form action="/save" method="get">
    <span>
        <input type="checkbox" id="lettuce" name="condiment" value="lettuce">
        <label for="lettuce"> Lettuce</label>
        <input type="checkbox" id="tomato" name="condiment" value="tomato">
        <label for="tomato"> Tomato</label>
        <input type="checkbox" id="mustard" name="condiment" value="mustard">
        <label for="mustard"> Mustard</label>
        <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
        <label for="sprouts"> Sprouts</label>
    </span>
    <input type="submit" value="Save">
</form>

</body>
</html>
