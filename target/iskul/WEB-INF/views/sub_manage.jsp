<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 2/27/2017
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject Manage</title>

    <%--<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

<div align="center" class="container">
    <h1>User List</h1>

    <table class="table table-striped">
        <th>Subject</th>
        <th>Subject Category</th>
         <th>Action</th>
        <c:forEach var="subject" items="${listSubject}">
            <tr>
                <%--<td><a href="subjectDetails/?id=${subject.id}">${subject.sub_title}</a></td>--%>
                    <td>
                        ${subject.sub_title}
                    </td>
                    <td>
                        ${subject.category.title}
                    </td>

                    <td>
                        <a href="editSubject?id=${subject.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteSubject?id=${subject.id}">Delete</a>
                    </td>
            </tr>
        </c:forEach>
    </table>

    <h4> New Subject ?? Register <a href="newSubject">here</a> </h4>
</div>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>


</body>
</html>
