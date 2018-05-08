<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 3/7/2017
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#cat_select" ).change(function () {
                var id =$('#cat_select').val();
                if(id !=0) {
                    var subject = "";
                    $.ajax({
                        type: 'GET',
                        url: 'getSubjectsForQuiz',
                        data: {id: id},
                        success: function (result) {
                            $('#sub_select').html(result);
                            onSubjectChange();
                        }
                    });
                }
                else{
                    $('#sub_select').html("");
                    $('#topicSelect').html("");
                }
            });

            $( "#sub_select" ).change(function () {
                onSubjectChange();
            })

            function onSubjectChange(){
                var id =$('#sub_select').val();
                if(id !=0) {
                    var topic = "";
                    $.ajax({
                        type: 'GET',
                        url: 'getTopicsForQuiz',
                        data: {id: id},
                        success: function (result) {
                            $('#topicSelect').html(result);
                        }
                    });
                }
                else{
                    $('#topicSelect').html("");
                }
            }
        });
    </script>
</head>
<body>
<form:form action="/manage/adminTeacher/addQuestion" method="post" modelAttribute="questionForm">
    <table>
        <tr>
            <td>Write a Question : </td>
            <form:hidden path="id"/>
            <td><form:input type="text" path="question"/>
                <form:errors  path="question" />
            </td>
        </tr>

        <tr>
            <td>Write Options : </td>

            <td>1.<form:input type = "text" path="option1"/></td>

            <td>2.<form:input type = "text" path="option2"/></td>

            <td>3.<form:input type = "text" path="option3"/></td>

            <td>4.<form:input type = "text" path="option4"/></td>
        </tr>

        <tr>
            <td>Correct Answer</td>
            <td><form:select path="correctAnswer">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </form:select>
            </td>
        </tr>

        <%--For SubjectWise Topic--%>
        <tr>
            <td>Category : </td>
            <td>
                <select  id="cat_select">
                    <option value="0">- select category -</option>>
                    <c:forEach items="${listCategoryForQuiz}" var="category">
                        <option value="${category.id}" >${category.title}</option>
                    </c:forEach>
                </select>

            </td>
        </tr>
        <tr>
            <td>Subject : </td>
            <td>
                    <select  id="sub_select">

                    </select>

            </td>
        </tr>


        <tr>
            <td>Choose Topic</td>
            <td>
                <%--<form:select path="topic" >--%>
                    <%--<option>- Select Topic -</option>>--%>
                    <%--<c:forEach items="${topicList}" var="topic">--%>
                        <%--<option value="${topic.id}" >${topic.topic_title}</option>--%>
                    <%--</c:forEach>--%>
                <%--</form:select>--%>

                    <form:select path="topic" id="topicSelect">

                    </form:select>
                    <form:errors  path="topic"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>

</form:form>
</body>
</html>
