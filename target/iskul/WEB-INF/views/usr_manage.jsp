<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 2/26/2017
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Management</title>

    <%--<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>

<h3>Welcome ${username} </h3>

<div align="center" class="container">
    <h1>User List</h1>

    <table class="table table-striped">
        <th>Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Password</th>
        <th>User Type</th>
        <th>Action</th>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td>${user.userName}</td>
                <td>${user.email}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.password}</td>
                <td>${user.userType}</td>
                <td><a href="editUser?id=${user.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="deleteUser?id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <h4> New User Register <a href="newUser">here</a> </h4>
</div>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>

</body>
</html>
