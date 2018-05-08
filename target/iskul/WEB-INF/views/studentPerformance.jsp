<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 4/19/2017
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Performance</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<h4> Welcome ${username}</h4><br>

Topic :${topic.topic_title}
<table class="table table-striped container" >
    <th>Student Name</th>
    <th>Full Marks</th>
    <th>Earned Marks</th>
    <th>Exam Date</th>

    <c:forEach var="performance" items="${performance}">
        <tr>
            <td>${performance.user.userName}</td>
            <td>${performance.full_marks}</td>
            <td>${performance.earned_marks}</td>
            <td>${performance.date}</td>
        </tr>

    </c:forEach>
</table>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
