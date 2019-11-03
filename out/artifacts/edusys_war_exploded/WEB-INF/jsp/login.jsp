<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="/static/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <!-- Google fonts - Popppins for copy-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">
    <!-- orion icons-->
    <link rel="stylesheet" href="/static/css/orionicons.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="/static/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="/static/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="/static/img/favicon.png?3">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
    <script src="/static/https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="/static/https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
<div class="page-holder d-flex align-items-center">
    <div class="container">
        <c:if test="${not empty msg}"><div class="alert alert-${msg_type}">${msg}</div></c:if>
        <div class="row align-items-center py-5">
            <div class="col-5 col-lg-7 mx-auto mb-5 mb-lg-0">
                <div class="pr-lg-5"><img src="/static/img/illustration.svg" alt="" class="img-fluid"></div>
            </div>
            <div class="col-lg-5 px-lg-4">
                <h1 class="text-base text-primary text-uppercase mb-4">尊敬的${title}</h1>
                <h2 class="mb-4">欢迎登录！</h2>
                <form id="loginForm" action="/${type}/login" method="post"  class="mt-4">
                    <div class="form-group mb-4">
                        <input type="text" name="username" placeholder="请输入用户名" required class="form-control border-0 shadow form-control-lg text-violet">
                    </div>
                    <div class="form-group mb-4">
                        <input type="password" name="password" placeholder="请输入密码" required class="form-control border-0 shadow form-control-lg text-violet">
                    </div>
                    <button type="submit" class="btn btn-primary shadow px-5">登录</button>&nbsp;
                    <c:if test="${type!= 'admin'}">
                    |&nbsp;<a href="/${type}/toRegister">免费注册</a>
                    </c:if>
                </form>
            </div>
        </div>

    </div>
</div>
<!-- JavaScript files-->
<script src="/static/vendor/jquery/jquery.min.js"></script>
<script src="/static/vendor/popper.js/umd/popper.min.js"> </script>
<script src="/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="/static/vendor/chart.js/Chart.min.js"></script>
<script src="/static/js/js.cookie.min.js"></script>
<script src="/static/js/front.js"></script>
</body>
</html>