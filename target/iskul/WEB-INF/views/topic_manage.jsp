<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 2/27/2017
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topic Mangement</title>

    <%--<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div>

    <div align="center" class="container">
        <h1>Topic List</h1>

        <table class="table table-striped">
            <th>Topic Title</th>

            <th>Subject </th>
            


            <th>Action</th>
            <c:forEach var="topic" items="${listTopic}">
                <tr>
                    <%--<td><a href="startQuiz/?id=${topic.id}">${topic.topic_title}</a></td>--%>
                        <td>
                            ${topic.topic_title}
                        </td>

                        <td>
                            ${topic.subject.sub_title}
                        </td>

                        <td>
                            <a href="editTopic?id=${topic.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="deleteTopic?id=${topic.id}">Delete</a>
                        </td>
                </tr>
            </c:forEach>
        </table>

        <h4> New topic ?? Register <a href="newTopic">here</a> </h4>
    </div>
</div>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>

</body>
</html>
