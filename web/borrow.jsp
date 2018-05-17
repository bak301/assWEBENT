<%--
  Created by IntelliJ IDEA.
  User: bak
  Date: 17/05/2018
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrow</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/main.css">
</head>
<body>
<main class="container">
    <div class="jumbotron">
        <h1>Borrow book</h1>
        <form action="/book/${requestScope.bookId}/borrow" method="POST">
            <div class="form-group">
                <label for="bookId">Book ID : </label>
                <input id="bookId" class="form-control-plaintext" type="text" name="bookId"
                       value="${requestScope.bookId}" readonly/>
            </div>

            <div class="form-group">
                <label for="borrowDateTime">Borrow Date time : </label>
                <input type="datetime-local" id="borrowDateTime" class="form-control" name="borrowDateTime"/>
            </div>

            <input class="btn btn-primary" type="submit" name="borrow" value="Set book's state to Borrowed">
        </form>
    </div>
</main>
</body>
</html>
