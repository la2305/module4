<%--
  Created by IntelliJ IDEA.
  User: La
  Date: 7/18/2023
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/change" method="post">
  <h1>Money change apllication</h1>
  <p1>input money you want to change</p1>
  <input type="number" name="money" placeholder="input money">
  <p1>input rate of money you want to change</p1>
  <input type="number" name="rate" placeholder="input rate">
  <button>Save</button>
  <br>
  <p1>Result:</p1>
  <p1>${moneyAfterChange}</p1>
</form>
</body>
</html>
