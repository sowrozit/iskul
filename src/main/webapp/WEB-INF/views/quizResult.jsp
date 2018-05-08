<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 3/14/2017
  Time: 12:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz Result</title>

    <%--<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>--%>
    <%--<script type="text/javascript" language="javascript">--%>
        <%--$(document).ready(function () {--%>
            <%--$(".question-id").css("background-color","cyan");--%>
        <%--});--%>
    <%--</script>--%>
</head>
<body>

<div>
    <h1>Quiz Result</h1>

    <div>
        <c:forEach var="questions" items="${listOfQuestion}">
            <div class="question">
                <div>
                        ${questions.id}. ${questions.question}<br><br>
                    <input class="question-id" type="hidden" value="${questions.id}" name="question_${questions.id}">
                </div>
                <div>
                    <c:forEach var="options" items="${questions.options}">
                        <input type="radio" class="question-answer" name="question_${questions.id}option-${questions.id}[]" value="${options.id}">${options.option}<br><br>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

</body>
</html>
