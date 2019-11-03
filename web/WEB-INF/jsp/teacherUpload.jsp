<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>控制台</title>
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
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
<!-- navbar-->
<header class="header">
    <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow">
        <ul class="ml-auto d-flex align-items-center list-unstyled mb-0">
            <li class="nav-item dropdown ml-auto"><a id="userInfo" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle"><img src="/static/img/avatar-6.jpg" alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></a>
                <div aria-labelledby="userInfo" class="dropdown-menu"><a href="#" class="dropdown-item"><strong class="d-block text-uppercase headings-font-family">${user.username}</strong><small>${user.name}</small></a>
                    <div class="dropdown-divider"></div><a href="/${type}/logout" class="dropdown-item">退出登录</a>
                </div>
            </li>
        </ul>
    </nav>
</header>
<div class="d-flex align-items-stretch">
    <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
            <c:if test="${user.status == -1}">
                <center>
                    <h1 class="py-4">审核信息已提交，请耐心等待管理员审核！</h1>
                </center>
            </c:if>
            <c:if test="${user.status == -2}">
                <section class="py-5">
                    <div class="row">
                        <div class="col-lg-12 mb-5">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="h6 text-uppercase mb-0">提交审核信息</h3>
                                </div>
                                <div class="card-body">
                                    <form action="/${type}/upload" method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label class="form-control-label text-uppercase">年龄</label>
                                            <input type="text" required name="age" required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label text-uppercase">身份证号码</label>
                                            <input type="text" required name="idNumber" required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label text-uppercase">职业</label>
                                            <input type="text" required name="role" required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label text-uppercase">学校</label>
                                            <input type="text" required name="school" required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label text-uppercase">证件照</label>
                                            <input type="file" required name="pic" required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-control-label text-uppercase">证明材料</label>
                                            <input type="file" required name="cert" required class="form-control">
                                        </div>

                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary">提交</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </c:if>
        </div>
        <footer class="footer bg-white shadow align-self-end py-3 px-xl-5 w-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 text-center text-md-left text-primary">
                        <p class="mb-2 mb-md-0"></p>
                    </div>
                    <div class="col-md-6 text-center text-md-right text-gray-400">
                        <p class="mb-0">Copyright &copy; 2019.sw1612 All rights reserved.</p>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<!-- JavaScript files-->
<script src="/static/vendor/jquery/jquery.min.js"></script>
<script src="/static/vendor/popper.js/umd/popper.min.js"> </script>
<script src="/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="/static/vendor/chart.js/Chart.min.js"></script>
<script src="/static/js/js.cookie.min.js"></script>
<script src="/static/js/charts-home.js"></script>
<script src="/static/js/front.js"></script>
</body>
</html>
