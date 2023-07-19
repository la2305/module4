<%--
  Created by IntelliJ IDEA.
  User: La
  Date: 7/19/2023
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<table>
    <h1>Result</h1>
    <c:if test="${msg !=null}">
        <p>${msg}</p>
    </c:if>
    <c:if test="${condiment !=null}">
        <table>
            <tr>
                <th>STT</th>
                <th>NAME</th>
            </tr>
            <c:forEach varStatus="loop" items="${condiment}" var="s">
                <tr>
                    <td>${loop.count}</td>
                    <td>${s}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</table>
</body>
</html>
