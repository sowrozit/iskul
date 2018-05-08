<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 3/31/2017
  Time: 2:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category Management</title>

    <%--<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

<div align="center" class="container">
    <table class="table table-striped">
        <th>${category.title}</th>
        <c:forEach var="subject" items="${subjectListForAll}">
        <tr>
            <td>
                <a href="/manage/adminTeacherStudent/atsSubjectDetails?id=${subject.id}">${subject.sub_title}</a>
            </td>
        </tr>

            </c:forEach>
    </table>
</div>


<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
</body>
</html>
</html>
