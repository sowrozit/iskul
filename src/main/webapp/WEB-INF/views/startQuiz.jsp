
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 3/10/2017
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>StartQuiz</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/compiled/flipclock.css" />" rel="stylesheet">


    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>




    <script type="text/javascript" text="javascript" >

        $(document).ready(function(){
            $("#submit").click(function(){
                var questions = [];
                $('.question').each(function(){
                    var questionId = $(this).find('.question-id').val();
                    var checked = $(this).find('.question-answer:checked').val();

                    var optionValue;
                    if(typeof checked != 'undefined'){
                        optionValue = checked;
                    }
                    else{
                        optionValue = null;
                    }

                    questions.push({
                        'questionId': questionId,
                        'optionId': optionValue
                    });
                });
                console.log(questions);
                //send data to backend to verify
                var id = $('#hidden-id').val();
                $.ajax({
                    type:'POST',
                    url:'quizSubmission',
//                    data:{'questions' : JSON.stringify(questions)},
                    data:{'questions' : JSON.stringify(questions), id: id},
                    success: function(result) {
//                        window.location.href= 'quizResult';
//                        url = url.replace("processData", "getMoreData");
//                        alert(url); // correct url is printed
//                        window.location.replace(url);
                        $('#container').html(result);
                    }
// ,
//                    error: function() {
//                        alert("--- Failure ---");
//                    }
                });
            });
//            $('form').on('submit', function(e) {
//                e.preventDefault();
//            });
        });

    </script>
</head>
<body>
<h2>Let's Start..</h2>



<%--<script type="text/javascript">--%>
    <%--var clock;--%>

    <%--$(document).ready(function() {--%>

        <%--clock = $('.clock').FlipClock({--%>
            <%--clockFace: 'MinuteCounter'--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>


<script type="text/javascript">
    var clock;

    $(document).ready(function() {

        clock = $('.clock').FlipClock(10, {
            clockFace: 'MinuteCounter',
            countdown: true,
            callbacks: {
                stop: function() {
                    $('#submit').click();
                }
            }
        });

    });

</script>

<div id="container">
    <div class="clock" style="margin:2em;"></div>
    <div class="message"></div>
    <div>
        <h1>Question List</h1>
        <div>
            <h3>Questions </h3>
        </div>
        <div>
            <form:form action=" " method="post">
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
                <input type="button" id="submit" value="Submit">
                <a href="quizResult/?id=${topic.id}">Click Here</a>
            </form:form>
        </div>
    </div>
</div>


<div id="result">

</div>

<div>
    <input type="hidden"  id="hidden-id" value="${exam.unique_id}">
</div>


<script src="/resources/compiled/flipclock.min.js"></script>



</body>
</html>
