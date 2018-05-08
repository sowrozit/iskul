
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 2/27/2017
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categort Add</title>
</head>
<body>

<div align="center">
    <h1>New/Edit Category</h1>
    <form:form action="newCategory" method="post" modelAttribute="category">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Title :</td>
                <td>
                    <form:input path="title"/>
                    <form:errors  path="title" />
                </td>

                <%--<td>--%>
                    <%--<form:select path="title">--%>
                        <%--<option value="JSC">JSC</option>--%>
                        <%--<option value="SSC">SSC</option>--%>
                        <%--<option value="HSC">HSC</option>--%>
                    <%--</form:select>--%>
                <%--</td>--%>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
