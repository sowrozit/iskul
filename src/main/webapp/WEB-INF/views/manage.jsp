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
    <table>
        <tr>
            <td><a href="logout">Logout</a></td>
        </tr>
        <tr>
            <td><a href="usr_manage">view employee list</a></td>
        </tr>
        <tr>
            <td><a href="ctg_manage">view category list</a></td>
        </tr>
        <tr>
            <td><a href="sub_manage">Click here for view the subjects.</a></td>
        </tr>
        <tr>
            <td><a href="topic_manage">Click here for view the topics.</a></td>
        </tr>
        <tr>
            <td><a href="addQuestion"> Click Here For Quiz</a></td>
        </tr>
    </table>
</div>
</body>
</html>