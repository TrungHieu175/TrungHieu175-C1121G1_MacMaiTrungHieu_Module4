<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Greeting</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <form action="/converter" method="post">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 m-lg-auto">
                    <div class="mb-3">
                        <label for="number1" class="form-label">USD</label>
                        <input type="text" class="form-control" id="number1" name="usd">
                    </div>
                    <button type="submit" class="btn btn-primary">Converter</button>
                    <div>
                        <p>Result USD to VND ${result}</p>
                    </div>
                </div>
            </div>
        </div>
    </form>

</body>
</html>
