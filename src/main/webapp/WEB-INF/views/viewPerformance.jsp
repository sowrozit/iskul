<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 4/20/2017
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Performance</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div>

    <div align="center" class="container">
        <h1>Topic List</h1>

        <table class="table table-striped">
            <th>Topic Title</th>

            <th>Student Performance</th>

            <th>Subject </th>
            <th>Category</th>

            <c:forEach var="topic" items="${listTopic}">
                <tr>
                    <td>
                            ${topic.topic_title}
                    </td>


                    <td>
                        <a href="/manage/adminTeacher/studentPerformance?id=${topic.id}">View Result</a>
                    </td>

                    <td>
                            ${topic.subject.sub_title}
                    </td>

                    <td>
                        ${topic.subject.category.title}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>

</body>
</html>

