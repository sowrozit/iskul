<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 4/21/2017
  Time: 3:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
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
            <td><a href="adminTeacher/uploadform"> File Upload</a></td>
        </tr>
    </table>
</div>

</body>
</html>
