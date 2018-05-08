
<%--
  Created by IntelliJ IDEA.
  User: Sowrozit
  Date: 3/31/2017
  Time: 2:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category For ATS</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<%--bootstrap--%>
    <link rel="apple-touch-icon" sizes="76x76" href="/resources/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/resources/assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Material Kit by Creative Tim</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <!-- CSS Files -->
    <link href="/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/resources/assets/css/material-kit.css" rel="stylesheet"/>

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="/resources/assets/css/demo.css" rel="stylesheet" />
</head>
<body>
<%--<div align="center" class="container">--%>
    <%--<h1>Category List</h1>--%>

    <%--<table class="table table-striped">--%>
        <%--<th>Title</th>--%>
        <%--<c:forEach var="category" items="${listCategoryForAll}">--%>
            <%--<tr>--%>
                <%--<td><a href="atsCategoryDetails/?id=${category.id}">${category.title}</a></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
<%--</div>--%>
<div class="row">
    <div>Category List</div>
    <c:forEach var="category" items="${listCategoryForAll}">
        <div>
            <a href="atsCategoryDetails/?id=${category.id}"><button class="btn btn-primary btn-lg" >${category.title}</button></a>
        </div>
    </c:forEach>
</div>




<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <button class="btn btn-primary btn-lg">JSC</button>
        <button class="btn btn-primary btn-lg">SSC</button>
        <button class="btn btn-primary btn-lg">HSC</button>
    </div>
</div>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
<!--  End Modal -->


</body>
<!--   Core JS Files   -->
<script src="/resources/assets/js/jquery.min.js" type="text/javascript"></script>
<script src="/resources/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/resources/assets/js/material.min.js"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="/resources/assets/js/nouislider.min.js" type="text/javascript"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script src="/resources/assets/js/bootstrap-datepicker.js" type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="/resources/assets/js/material-kit.js" type="text/javascript"></script>

<script type="text/javascript">

    $().ready(function(){
        // the body of this function is in assets/material-kit.js
        materialKit.initSliders();
        window_width = $(window).width();

        if (window_width >= 992){
            big_image = $('.wrapper > .header');

            $(window).on('scroll', materialKitDemo.checkScrollForParallax);
        }

    });
</script>
</html>
