<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 3/7/2017
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
    <%--<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div>

    <div align="center" class="container">
        <h1>Question List</h1>

        <table class="table table-striped">
            <th>Questions </th>
            <th>Options</th>
            <th>Topic</th>
            <th>Subject</th>
            <th>Category</th>
            <th>Action</th>
            <c:forEach var="questions" items="${questionList}">
                <tr>
                    <td>${questions.question}</td>

                    <td>
                        <ol>
                            <c:forEach var="options" items="${questions.options}">
                                <li>
                                    ${options.option}
                                </li>
                            </c:forEach>
                        </ol>
                    </td>

                    <td>
                        ${questions.topic.topic_title}
                    </td>
                    <td>
                        ${questions.topic.subject.sub_title}
                    </td>
                    <td>
                        ${questions.topic.subject.category.title}
                    </td>
                    <td>
                        <a href="/manage/adminTeacher/editQuestion?id=${questions.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/manage/adminTeacher/deleteQuestion?id=${questions.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h4> New Question ?? Register <a href="/manage/adminTeacher/addQuestion">here</a> </h4>
    </div>
</div>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>

</body>
</html>