<%--
  Created by IntelliJ IDEA.
  User: athma
  Date: 9/10/18
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>STP Form</title>
</head>
<body>
<form method="POST" action="tokenvalidate">
    <input type="text" name="Enter the email" required/><br><br>
    <input type="hidden" id="token" name="token" value="${sessionScope.token}">
    <input type="submit" name="submit" value="Submit">
</form>
</body>
</html>
