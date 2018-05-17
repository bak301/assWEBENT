<%--
  Created by IntelliJ IDEA.
  User: bak
  Date: 16/05/2018
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
      <header class="jumbotron">
        <h1>Welcome to bookstore !</h1>
        <form action="/result" method="post">
          <div class="form-group">
            <label for="sname">Name</label>
            <input id="sname" class="form-control" type="text" name="searchByName" placeholder="Leave this blank to search all books ..">
          </div>
          <input type="submit" class="btn btn-primary" name="sname" value="Search By Name">

          <div class="form-group">
            <label for="sid"> ID </label>
            <input id="sid" class="form-control" type="number" name="searchById" placeholder="..ID..">
          </div>
          <input type="submit" class="btn btn-primary" name="sid" value="Search By ID">
        </form>
      </header>
    </div>
  </body>
</html>
