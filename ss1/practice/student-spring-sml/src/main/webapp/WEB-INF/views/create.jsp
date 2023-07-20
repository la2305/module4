<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form modelAttribute="student" action="/student/create" method="post">
    ID
    <form:input path="id"/><br>
    Name
    <form:input path="name"/><br>
    Gender
    <form:select path="gender">
        <form:option value="1">Nam</form:option>
        <form:option value="0">Nữ</form:option>
        <form:option value="-1">LGBT</form:option>
    </form:select>
    Languages
    <form:checkboxes path="languages" items="${ngonNgu}"/>
    <form:button>Add</form:button>
</form:form>
</body>
</html>
