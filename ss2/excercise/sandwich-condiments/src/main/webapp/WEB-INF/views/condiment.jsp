<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<br/>
<form action="/result" method="post">
    <input type="checkbox" name="condiment" value="Lettuce"><p1>Lettuce</p1>
    <input type="checkbox" name="condiment" value="Tomato"><p1>Tomato</p1>
    <input type="checkbox" name="condiment" value="Mustard"><p1>Mustard</p1>
    <input type="checkbox" name="condiment" value="Sprouts"><p1>Sprouts</p1>
    <button type="submit">Save</button>
</form>
</body>
</html>