<%--
  Created by IntelliJ IDEA.
  User: bak
  Date: 16/05/2018
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
      <header class="jumbotron">

        <h1>Welcome to bookstore !</h1>

        <form action="/book" method="GET">
          <div class="form-group">
            <small id="nameSuggest" class="form-text text-muted">Leave this field blank to search all books</small>
            <input class="form-control form-control-lg"
                   type="text"
                   name="searchByName"
                   placeholder="..Name.."
                   aria-describedby="nameSuggest">
            <input type="submit" class="btn btn-primary" name="sname" value="Search By Name">
          </div>

          <div class="form-group">
            <input class="form-control form-control-lg"
                   type="number"
                   name="searchById"
                   placeholder="..ID..">
            <input type="submit" class="btn btn-primary" name="sid" value="Search By ID">
          </div>
        </form>

      </header>

    </div>
  </body>
</html>
