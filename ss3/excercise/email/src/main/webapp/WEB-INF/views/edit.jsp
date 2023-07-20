<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Setting</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/email/edit" method="post" modelAttribute="email">
    <form:hidden path="id"/>
    Languages
    <form:select path="language" items="${ngonNgu}"/>
    Size
    <form:select path="size" items="${pageSize}"/>
    Filter
    <form:checkbox path="filter"/>
    Signature
    <form:textarea path="signature"/>
    <form:button>Update</form:button>
</form:form>
</body>
</html>
