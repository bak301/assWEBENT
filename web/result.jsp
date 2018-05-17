<%--
  Created by IntelliJ IDEA.
  User: bak
  Date: 16/05/2018
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result Page</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/main.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</head>
<body>
<main class="container">
    <header class="jumbotron">
        <h1>Search result : </h1>
    </header>
    <div class="table-responsive">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Is Borrowed</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.list}" var="book">
                    <tr>
                        <td>${book.getId()}</td>
                        <td>${book.getName()}</td>
                        <td>${book.getAuthor()}</td>
                        <td>
                            <button class="btn btn-primary"
                                    type="button"
                                    data-toggle="collapse"
                                    data-target="#collapse${book.getId()}"
                                    aria-expanded="false"
                                    aria-controls="collapse${book.getId()}">
                                ${book.isBorrowed()}
                            </button>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" style="padding: 0;"></td>
                        <td colspan="2" style="padding: 0;">
                            <table class="table collapse" id="collapse${book.getId()}">
                                <thead>
                                    <th>Borrow Date</th>
                                    <th>Return Date</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${book.getHistory()}" var="history">
                                    <tr>
                                        <td>${history.getBorrowedTime()}</td>
                                        <td>${history.getReturnedTime()}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>
