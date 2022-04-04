<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 4/1/2022
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form action="update" method="post">

    <label for="languages"><strong>Languages :</strong></label>
    <select id="languages" name="languages">
        <option value="english">English</option>
        <option value="vietnamese">Vietnamese</option>
        <option value="japanese">Japanese</option>
        <option value="chinese">Chinese</option>
    </select><br><br>

    <label for="size"><strong>Page Size :</strong></label>
    <span>Show
    <select id="size" name="size">
        <option value="english">5</option>
        <option value="vietnamese">10</option>
        <option value="japanese">15</option>
        <option value="chinese">20</option>
        <option value="chinese">25</option>
        <option value="chinese">50</option>
        <option value="chinese">100</option>
    </select> emails per page</span><br><br>

    <label for="fillter"><strong>Spams fillter :</strong></label>
    <input type="checkbox" id="fillter" name="fillter">
    <label for="fillter"> Enable spam fillter</label><br><br>

    <label for="signature"><strong>Signature :</strong></label>
    <textarea name="signature" rows="10" cols="30" id="signature">Thor Son of Odin
    </textarea><br><br>

    <input type="submit" value="Update">
    <input type="submit" value="Cancel">
</form>
</body>
</html>
