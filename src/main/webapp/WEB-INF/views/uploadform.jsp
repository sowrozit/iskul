<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 5/5/2017
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UploadForm</title>
</head>
<body>
<h1>File Upload Example - JavaTpoint</h1>

<h3 style="color:red">${filesuccess}</h3>
<form:form method="post" action="savefile" enctype="multipart/form-data">
    <p><label for="fileToUpload">Choose Image</label></p>
    <p><input name="file" id="fileToUpload" type="file" /></p>
    <p><input type="submit" value="Upload"></p>
</form:form>
</body>
</html>
