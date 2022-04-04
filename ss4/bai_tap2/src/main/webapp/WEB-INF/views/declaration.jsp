
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tờ Khai Y Tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    <link rel="stylesheet" href="boostrap/css/bootstrap.min.css">--%>
</head>
<body>
<div class="container text-center">
    <div class="row">
        <h1>Tờ Khai Y Tế</h1>
        <h3>THÔNG TIN CỦA BẠN ... PHÒNG CHỐNG DỊCH BỆNH</h3>
        <h5 style="color: red">Khuyến cáo : khai báo sai = vi phạm PL</h5>
    </div>
</div>

<form:form action="/declaration" method="post" modelAttribute="declaration">
    <div class="container">
        <div class="row">
            <div class="form-group">
                <label for="exampleFormControlInput1">Họ Tên</label><span class="text-danger">(*)</span>
                <form:input path="name" type="text" class="form-control" id="exampleFormControlInput1"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-4">
                <label for="exampleFormControlInput2">Năm Sinh</label><span class="text-danger">(*)</span>
                <form:input path="dateOfBirth" type="text" class="form-control" id="exampleFormControlInput2"/>
            </div>
            <div class="form-group col-4">
                <label for="exampleFormControlInput3">Giới tính</label><span class="text-danger">(*)</span>
                <form:select items="${gender}" path="gender" type="text" class="form-control"
                             id="exampleFormControlInput3"/>
            </div>
            <div class="form-group col-4">
                <label for="exampleFormControlInput4">Quôc tịch</label><span class="text-danger">(*)</span>
                <form:select path="nationality" items="${nationality}" type="text" class="form-control"
                             id="exampleFormControlInput4"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="exampleFormControlInput5">CMND</label><span class="text-danger">(*)</span>
                <form:input path="idCard" type="text" class="form-control" id="exampleFormControlInput5"/>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-6">
            </div>
            <div class="col-6 ">
                <button class="btn btn-success mx-auto" type="submit">Gửi</button>
            </div>
        </div>
    </div>
</form:form>
<p class="text-danger">${mess}</p>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

</html>
