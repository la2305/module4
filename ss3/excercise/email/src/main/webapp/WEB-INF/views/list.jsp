<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: La
  Date: 7/20/2023
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>STT</th>
        <th>Language</th>
        <th>Size</th>
        <th>Filter</th>
        <th>Signature</th>
        <th>Action</th>
    </tr>
    <c:forEach var="language" items="${emailList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${language.language}</td>
            <td>${language.size}</td>
            <td>${language.filter}</td>
            <td>${language.signature}</td>
            <td><a href="/email/edit?id=${language.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
