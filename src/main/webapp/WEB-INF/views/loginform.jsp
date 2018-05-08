<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
            <%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
    <%--<title>Login</title>--%>

    <%--&lt;%&ndash;<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">&ndash;%&gt;--%>

    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">--%>


    <%--<!-- Compiled and minified CSS -->--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">&ndash;%&gt;--%>



<%--</head>--%>
<%--<body>--%>

            <%--&lt;%&ndash;<div class="container" margin-top="200px">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<form:form action="login"  commandName="loginForm">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="form-group row">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="col-sm-10">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<form:input type="userName" path="userName" class="form-control" id="inputEmail3" required="required"/>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="form-group row">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="col-sm-10">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<form:input type="password" path="password" class="form-control" id="inputPassword3" required="required"/>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="form-group row">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div align="center" class="offset-sm-2 col-sm-10">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<button type="submit" class="btn btn-primary">Sign in</button>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</form:form>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--<div>--%>
                <%--<nav class="navbar navbar-inverse navbar-fixed-top">--%>
                    <%--<div class="container-fluid">--%>
                        <%--<div class="navbar-header">--%>
                            <%--<a class="navbar-brand" href="index.jsp">Iskul</a>--%>
                        <%--</div>--%>
                        <%--<ul class="nav navbar-nav">--%>
                            <%--<li class="active"><a href="#">Home</a></li>--%>
                            <%--<li><a href="#">About</a></li>--%>
                            <%--<li><a href="#">Demo</a></li>--%>
                            <%--<li><a href="#">Contact Us</a></li>--%>
                        <%--</ul>--%>
                        <%--<ul class="nav navbar-nav navbar-right">--%>
                            <%--<li><a href="/registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>--%>
                            <%--<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                <%--</nav>--%>
            <%--</div>--%>
            <%--<div class="login">--%>
                <%--<div class="container">--%>
                    <%--<form:form class="form-inline" action="login" commandName="loginForm">--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="email">Email:</label>--%>
                                <%--&lt;%&ndash;<input type="email" class="form-control" id="email" placeholder="Enter username">&ndash;%&gt;--%>
                            <%--<form:input type="userName" path="userName" class="form-control" id="email"/>--%>
                        <%--</div>--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="pwd">Password:</label>--%>
                                <%--&lt;%&ndash;<input type="password" class="form-control" id="pwd" placeholder="Enter password">&ndash;%&gt;--%>
                            <%--<form:input type="password" path="password" class="form-control" id="pwd"/>--%>
                        <%--</div>--%>
                        <%--<div class="checkbox">--%>
                            <%--<label><input type="checkbox"> Remember me</label>--%>
                        <%--</div>--%>
                        <%--<button type="submit" class="btn btn-default">Submit</button>--%>
                    <%--</form:form>--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>--%>
        <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

        <%--&lt;%&ndash;<script src="webjars/jquery/1.9.1/jquery.min.js"></script>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>&ndash;%&gt;--%>


<%--</body>--%>
<%--</html>--%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <style>body{padding-top: 60px;}</style>

    <%--<link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />--%>
    <link rel="stylesheet" href="/resources/login/bootstrap3/css/bootstrap.css">


    <link href="/resources/login/login-register.css" rel="stylesheet" />
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

    <script src="/resources/login/jquery/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="/resources/login/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
    <script src="/resources/login/login-register.js" type="text/javascript"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <a class="btn big-login" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">Log in</a>
            <a class="btn big-register" data-toggle="modal" href="javascript:void(0)" onclick="openRegisterModal();">Register</a></div>
        <div class="col-sm-4"></div>
    </div>


    <div class="modal fade login" id="loginModal">
        <div class="modal-dialog login animated">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Login with</h4>
                </div>
                <div class="modal-body">
                    <div class="box">
                        <div class="content">
                            <div class="social">
                                <a class="circle github" href="/auth/github">
                                    <i class="fa fa-github fa-fw"></i>
                                </a>
                                <a id="google_login" class="circle google" href="/auth/google_oauth2">
                                    <i class="fa fa-google-plus fa-fw"></i>
                                </a>
                                <a id="facebook_login" class="circle facebook" href="/auth/facebook">
                                    <i class="fa fa-facebook fa-fw"></i>
                                </a>
                            </div>
                            <div class="division">
                                <div class="line l"></div>
                                <span>or</span>
                                <div class="line r"></div>
                            </div>
                            <div class="error"></div>
                            <div class="form loginBox">
                                <form:form method="post" action="login" accept-charset="UTF-8" commandName="loginForm">
                                    <form:input id="email" class="form-control" path="userName" type="userName" placeholder="Email" name="email"/>
                                    <form:input id="password" class="form-control" path="password" type="password" placeholder="Password" name="password"/>
                                    <input class="btn btn-default btn-login" type="submit" value="Login">
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="content registerBox" style="display:none;">
                            <div class="form">
                                <form method="post" html="{:multipart=>true}" data-remote="true" action="/register" accept-charset="UTF-8">
                                    <input id="email" class="form-control" type="text" placeholder="Email" name="email">
                                    <input id="password" class="form-control" type="password" placeholder="Password" name="password">
                                    <input id="password_confirmation" class="form-control" type="password" placeholder="Repeat Password" name="password_confirmation">
                                    <input class="btn btn-default btn-register" type="submit" value="Create account" name="commit">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="forgot login-footer">
                            <span>Looking to
                                 <a href="javascript: showRegisterForm();">create an account</a>
                            ?</span>
                    </div>
                    <div class="forgot register-footer" style="display:none">
                        <span>Already have an account?</span>
                        <a href="javascript: showLoginForm();">Login</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
