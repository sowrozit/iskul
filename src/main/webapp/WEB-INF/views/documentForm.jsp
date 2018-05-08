<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 5/5/2017
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document Form</title>
</head>
<body>

<form:form action="newFile" method="post"  commandName="document">

    <table>
        <tr>
            <td>File Name</td>
            <td><form:input path="filename" /></td>
        </tr>
        <tr>
            <td>Document</td>
            <td><form:input type="file" path="content" name="file" id="file"/></td>
        </tr>

        <tr>
            <td>Topic </td>
            <td>
                <form:select path="topic.id">
                    <c:forEach items="${topicList}" var="topic">
                        <option value="${topic.id}">${topic.topic_title}</option>
                    </c:forEach>

                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add Document"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
