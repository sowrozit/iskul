<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 2/27/2017
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject</title>
    <%--<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
    <%--<script type="text/javascript">--%>
        <%--$(document).ready(function () {--%>
            <%--$( "#cat_select" )--%>
                <%--.change(function () {--%>
                    <%--var id =$('#cat_select').val();--%>
                    <%--if(id !=0) {--%>
                        <%--var subject = "";--%>
                        <%--$.ajax({--%>
                            <%--type: 'GET',--%>
                            <%--url: 'getSubjectsByCTG',--%>
                            <%--data: {id: id},--%>
                            <%--success: function (result) {--%>
                                <%--$('#sub_select').html(result);--%>
                            <%--}--%>
                        <%--});--%>
                    <%--}--%>
                    <%--else{--%>
                        <%--$('#sub_select').html("");--%>
                    <%--}--%>
                <%--})--%>
        <%--})--%>
            <%--.change();--%>
    <%--</script>--%>
</head>
<body>

<div align="center">
    <h1>New/Edit Subject</h1>
    <form:form action="newSubject" method="post" modelAttribute="subject">
        <table>
            <form:hidden path="id"/>

                <%--Fetching Data from Category Table--%>

            <tr>
                <td>Category : </td>
                <td>
                    <form:select path="category.id">
                        <c:forEach items="${listCategory}" var="category">
                            <option value="${category.id}">${category.title}</option>
                        </c:forEach>
                    </form:select>

                </td>
            </tr>
            <tr>
                <td>Subject Name :</td>
                <td>
                    <form:select path="sub_title" >
                        <option value="Bangla">Bangla</option>
                        <option value="English">English</option>
                        <option value="Mathematics">Mathematics</option>
                        <option value="Physics">Physics</option>
                        <option value="Chemistry">Chemistry</option>
                        <option value="Biology">Biology</option>
                    </form:select>

                </td>
            </tr>


            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>

        </table>
    </form:form>
</div>

</body>
</html>
