<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 4/29/2017
  Time: 2:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserProfile</title>
</head>
<body>

<h3>Welcome ${username} </h3>

    <table class="table table-striped container">
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>

        <tr>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
        </tr>
    </table>


</body>
</html>
