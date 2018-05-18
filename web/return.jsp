<%--
  Created by IntelliJ IDEA.
  User: bak
  Date: 18/05/2018
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Return</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/main.css">
</head>
<body>
<main class="container">
    <div class="jumbotron">
        <h1>Return book</h1>
        <form action="/book/borrow" method="POST">
            <input type="hidden" name="_method" value="PUT">
            <div class="form-group">
                <label for="bookId">Borrow ID : </label>
                <input id="bookId" class="form-control-plaintext" type="text" name="id"
                       value="${requestScope.id}" readonly/>
            </div>

            <div class="form-group">
                <label for="returnDateTime">Return Date time : </label>
                <input type="datetime-local" id="returnDateTime" class="form-control" name="returnDateTime"/>
            </div>

            <input class="btn btn-primary" type="submit" name="return" value="Return book !">
        </form>
    </div>
</main>
</body>
</html>
