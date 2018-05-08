<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 2/26/2017
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New/Edit User</title>
</head>
<body>

    <div align="center">
        <h1>New/Edit User</h1>
        <form:form action="saveUser" method="post" modelAttribute="user" >
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>Name :</td>
                    <td><form:input path="userName" required="required" /></td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><form:input path="email" required="required"/></td>
                </tr>
                <tr>
                    <td>Phone Number :</td>
                    <td><form:input path="phoneNumber" required="required"/></td>
                </tr>
                <tr>
                    <td>Passowrd :</td>
                    <td><form:input path="password" required="required"/></td>
                </tr>
                <tr>
                    <td>User Type :</td>
                    <td>
                        <form:select path="userType" required="required">
                            <option value="admin">Admin</option>
                            <option value="teacher">Teacher</option>
                            <option value="student">Student</option>
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
