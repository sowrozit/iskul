<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 2/24/2017
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Management Screen</title>
</head>
<body>
<div>
    <h3>Welcome ${username} </h3>
    <h3>You are a Student</h3>
    <table>
        <%--<tr>--%>
            <%--<td><a href="quiz">Click here for view the topics.</a></td>--%>
        <%--</tr>--%>
        <tr>
            <td><a href="adminTeacherStudent/atsCategory">view category</a></td>
        </tr>
        <tr>
            <td><a href="logout">Logout</a></td>
        </tr>
        <tr>
            <td><a href="adminTeacherStudent/performanceHistory">View Performance</a></td>
        </tr>


    </table>


</div>
</body>
</html>
