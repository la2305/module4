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
<p style="color: red">${mess}</p>
<br>
<table>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>NAME</th>
        <th>GENDER</th>
        <th>LANGUAGES</th>
        <th>Detail-RequestParam</th>
        <th>Detail-PathVariable</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <c:if test="${student.gender ==1}">
                <td>Nam</td>
            </c:if><c:if test="${student.gender ==0}">
                <td>Nữ</td>
            </c:if><c:if test="${student.gender ==-1}">
                <td>LGBT</td>
            </c:if>
            <td>${student.languages}</td>
            <td>
                <a href="/student/detail?id=${student.id}">Detail-RequestParam</a>
                <a href="/student/detail/${student.id}">Detail-PathVariable</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
