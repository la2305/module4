<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: La
  Date: 7/18/2023
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student/create">Thêm mới</a>
<br>
<table>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
