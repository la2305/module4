<%--
  Created by IntelliJ IDEA.
  User: La
  Date: 7/19/2023
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/" method="post">
    <input type="number" name="first" placeholder="fisrt number">
    <input type="number" name="second" placeholder="second number">
    <button name="calculation" type="submit" value="+">Addition(+)</button>
    <button name="calculation" type="submit" value="-">Subtraction(-)</button>
    <button name="calculation" type="submit" value="*">Multiplication(*)</button>
    <button name="calculation" type="submit" value="/">Division(/)</button>
</form>
<c:if test="${mess == null}" >
    <h1>${result}</h1>
</c:if>
<h1>${mess}</h1>
</body>
</html>
