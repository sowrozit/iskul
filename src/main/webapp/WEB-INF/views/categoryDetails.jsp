<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 3/1/2017
  Time: 12:28 AM
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
        <th>Action</th>
            <c:forEach var="subject" items="${subjectList}">
                <tr>
                    <td>
                        <a href="/manage/adminTeacher/subjectDetails/?id=${subject.id}">${subject.sub_title}</a>
                    </td>

                    <td>
                        <a href="/manage/adminTeacher/editSubject?id=${subject.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/manage/adminTeacher/deleteSubject?id=${subject.id}">Delete</a>
                    </td>

            </c:forEach>
    </table>

    <h4> New Subject ?? Register <a href="/manage/adminTeacher/newSubject">here</a> </h4>
</div>


<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
</body>
</html>