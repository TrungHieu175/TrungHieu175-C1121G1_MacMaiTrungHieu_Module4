
<!DOCTYPE html>
<html  xmlns:th="http://www.thymeleaf.org">
<head th:replace="layout :: head">
</head>
<body>
<h3>Song List</h3>
<p>
    <a th:href="@{/create}">
        Add new Song
    </a>
</p>
<form th:action="@{/search}" method="get" >
    <input type="text" name="search"  placeholder="search song"/>
    <input type="submit"  value="Search">
</form>
<table id = "products">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Singer</th>
        <th>Music genre</th>
        <th>Link</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>View</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="music : ${musicList}">
        <td th:text="${music.}"></td>
        <td th:text="${music.name}"></td>
        <td th:text="${music.singer}"></td>
        <td th:text="${music.musicType}"></td>
        <td> <a th:href="${music.linkUrl}"> mp3</a></td>
        <td><a th:href="@{/edit/{id}(id=${music.id})}">edit</a></td>
        <td><a th:href="@{/delete/{id}(id=${music.id})}">delete</a></td>
        <td><a th:href="@{/view/{id}(id=${music.id})}">view</a></td>
    </tr>
    </tbody>
</table>
<footer th:replace="/layout :: footer"></footer>
</body>
</html>