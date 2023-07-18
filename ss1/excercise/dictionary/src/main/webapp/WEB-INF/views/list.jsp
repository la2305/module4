<%--
  Created by IntelliJ IDEA.
  User: La
  Date: 7/18/2023
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
<form action="/translate" method="post">
    <h1>Input word you want to translate Vietnamese</h1>
    <input type="text" name="word" placeholder="input">
    <button>Translate</button>
    <p1>${translate}</p1>
</form>
</body>
</html>
