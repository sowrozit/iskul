<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 4/21/2017
  Time: 2:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Home</title>
</head>
<body>
<div>
    <h3>Welcome ${username} </h3>
    <table>
        <tr>
            <td><a href="logout">Logout</a></td>
        </tr>
        <tr>
            <td><a href="admin/usr_manage">view employee list</a></td>
        </tr>
        <tr>
            <td><a href="admin/ctg_manage">view category list</a></td>
        </tr>
        <tr>
            <td><a href="adminTeacher/sub_manage">Click here for view the subjects.</a></td>
        </tr>
        <tr>
            <td><a href="adminTeacher/topic_manage">Click here for view the topics.</a></td>
        </tr>

        <tr>
            <td><a href="adminTeacher/viewPerformance">View Performance</a></td>
        </tr>

        <tr>
            <td><a href="adminTeacherStudent/atsCategory">view category</a></td>
        </tr>

        <tr>
            <td><a href="adminTeacher/quiz_manage"> Click Here For view Quiz</a></td>
        </tr>
    </table>
</div>
</body>
</html>
