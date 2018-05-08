<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Topic Form</title>

    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $( "#cat_select" ).change(function () {
                    var id =$('#cat_select').val();
                    if(id !=0) {
                        var subject = "";
                        $.ajax({
                            type: 'GET',
                            url: 'getSubjects',
                            data: {id: id},
                            success: function (result) {
                                $('#sub_select').html(result);
                            }
                        });
                    }
                    else{
                        $('#sub_select').html("");
                    }
                })
        })
    .change();
    </script>
</head>
<body>

<div align="center">
    <div>

    </div>
    <h1>New/Edit Subject</h1>
    <form:form action="newTopic" method="post" modelAttribute="topic">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Topic Title :</td>
                <td><form:input path="topic_title" /></td>
                <form:errors  path="topic_title" />
            </tr>
            <tr>
                <td>Category : </td>
                <td>
                    <select  id="cat_select">
                        <option value="0">- select category -</option>>
                        <c:forEach items="${listCategory}" var="category">
                            <option value="${category.id}" >${category.title}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <td>Subject : </td>
                <td>
                    <form:select path="subject.id" id="sub_select">

                    </form:select>
                    <form:errors  path="subject.id" />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
    </div>
</div>

</body>
</html>
