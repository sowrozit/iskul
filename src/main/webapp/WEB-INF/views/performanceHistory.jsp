<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 4/18/2017
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Performance History</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<c:forEach var="results" items="${results}">

<h4> Welcome ${username}</h4><br>
    <h3>Topic Title:  ${results.topic.topic_title}</h3>
<table class="table table-striped container">

    <th>Full Marks</th>
    <th>Earned Marks</th>
    <th>Exam Date</th>

                <tr>
                    <td>${results.full_marks}</td>
                    <td>${results.earned_marks}</td>
                    <td>${results.date}</td>
                </tr>

</table>
</c:forEach>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
