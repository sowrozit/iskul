
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 3/31/2017
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="<c:url value="/resources/images/something.jpg" />" rel="stylesheet">

</head>
<body>
<ol>

    Total Marks :<h1>${fullMarks}</h1>
    Your Earned Marks:<h1>${marks}</h1>

    <c:if test="${marks < 3 }">
        <img src="<c:url value="/resources/images/something.jpg"/>" alt="">
    </c:if>

    <c:forEach var="answer" items="${answers}">

            <li>
                    <c:forEach var="question" items="${jsonObject}">
                        <c:if test="${question.questionId == answer.questions.id}">
                            <c:if test="${question.optionId == answer.options.id}">
                                <p class="ques correct">${answer.questions.question}</p>
                            </c:if>
                            <c:if test="${question.optionId != answer.options.id}">
                                <p class="ques incorrect">${answer.questions.question}</p>
                            </c:if>
                        </c:if>
                    </c:forEach>

                <ul>
                    <c:forEach var="option" items="${answer.questions.options}">
                        <c:forEach var="json" items="${jsonObject}">
                                <c:if test="${json.questionId == answer.questions.id}">
                                    <li>${option.option}</li>
                                </c:if>
                        </c:forEach>
                    </c:forEach>
                    <p class=""><b>Correct Answer :</b>${answer.options.option}</p>
                </ul>
            </li>
    </c:forEach>
</ol>


</body>
</html>
