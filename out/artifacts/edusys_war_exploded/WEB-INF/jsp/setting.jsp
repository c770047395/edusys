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
    <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow"><a href="#" class="sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead"><i class="fas fa-align-left"></i></a><a href="/${type}/toMain" class="navbar-brand font-weight-bold text-uppercase text-base">家教平台</a>
        <ul class="ml-auto d-flex align-items-center list-unstyled mb-0">
            <li class="nav-item">
                <form id="searchForm" class="ml-auto d-none d-lg-block">
                    <div class="form-group position-relative mb-0">
                        <button type="submit" style="top: -3px; left: 0;" class="position-absolute bg-white border-0 p-0"><i class="o-search-magnify-1 text-gray text-lg"></i></button>
                        <input type="search" placeholder="搜索..." class="form-control form-control-sm border-0 no-shadow pl-4">
                    </div>
                </form>
            </li>
            <li class="nav-item dropdown mr-3"><a id="notifications" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle text-gray-400 px-1"><i class="fa fa-bell"></i><span class="notification-icon"></span></a>
                <div aria-labelledby="notifications" class="dropdown-menu"><a href="#" class="dropdown-item">
                    <div class="d-flex align-items-center">
                        <div class="icon icon-sm bg-violet text-white"><i class="fab fa-twitter"></i></div>
                        <div class="text ml-2">
                            <p class="mb-0">You have 2 followers</p>
                        </div>
                    </div></a><a href="#" class="dropdown-item">
                    <div class="d-flex align-items-center">
                        <div class="icon icon-sm bg-green text-white"><i class="fas fa-envelope"></i></div>
                        <div class="text ml-2">
                            <p class="mb-0">You have 6 new messages</p>
                        </div>
                    </div></a><a href="#" class="dropdown-item">
                    <div class="d-flex align-items-center">
                        <div class="icon icon-sm bg-blue text-white"><i class="fas fa-upload"></i></div>
                        <div class="text ml-2">
                            <p class="mb-0">Server rebooted</p>
                        </div>
                    </div></a><a href="#" class="dropdown-item">
                    <div class="d-flex align-items-center">
                        <div class="icon icon-sm bg-violet text-white"><i class="fab fa-twitter"></i></div>
                        <div class="text ml-2">
                            <p class="mb-0">You have 2 followers</p>
                        </div>
                    </div></a>
                    <div class="dropdown-divider"></div><a href="#" class="dropdown-item text-center"><small class="font-weight-bold headings-font-family text-uppercase">View all notifications</small></a>
                </div>
            </li>
            <li class="nav-item dropdown ml-auto"><a id="userInfo" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle"><img src="/static/img/avatar-6.jpg" alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></a>
                <div aria-labelledby="userInfo" class="dropdown-menu"><a href="#" class="dropdown-item"><strong class="d-block text-uppercase headings-font-family">${user.username}</strong><small>${user.name}</small></a>
                    <div class="dropdown-divider"></div><a href="#" class="dropdown-item">设置</a><a href="#" class="dropdown-item">日志       </a>
                    <div class="dropdown-divider"></div><a href="/${type}/logout" class="dropdown-item">退出登录</a>
                </div>
            </li>
        </ul>
    </nav>
</header>
<div class="d-flex align-items-stretch">
    <div id="sidebar" class="sidebar py-3">
        <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">主菜单</div>
        <ul class="sidebar-menu list-unstyled">
            <li class="sidebar-list-item"><a href="/${type}/toMain" class="sidebar-link text-muted"><i class="o-home-1 mr-3 text-gray"></i><span>首页</span></a></li>
            <li class="sidebar-list-item"><a href="/${type}/toOrderManager" class="sidebar-link text-muted" ><i class="o-survey-1 mr-3 text-gray"></i><span>家教中心</span></a></li>
            <li class="sidebar-list-item"><a href="#" data-toggle="collapse" data-target="#pages" aria-expanded="true" aria-controls="pages" class="sidebar-link text-muted"><i class="o-user-1 mr-3 text-gray"></i><span>用户</span></a>
                <div id="pages" class="collapse show">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item"><a href="/${type}/toSetting" class="sidebar-link text-muted pl-lg-5 active">修改资料</a></li>
                        <li class="sidebar-list-item"><a href="/${type}/toPassword" class="sidebar-link text-muted pl-lg-5 ">修改密码</a></li>
                        <li class="sidebar-list-item"><a href="/${type}/toDeposit" class="sidebar-link text-muted pl-lg-5">押金管理</a></li>
                    </ul>
                </div>
            </li>
            <li class="sidebar-list-item"><a href="/${type}/logout" class="sidebar-link text-muted"><i class="o-exit-1 mr-3 text-gray"></i><span>退出登录</span></a></li>
        </ul>
    </div>
    <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
            <section class="py-5">
                <div class="row">
                    <div class="col-lg-12 mb-5">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="h6 text-uppercase mb-0">修改个人资料</h3>
                            </div>
                            <div class="card-body">
                                <c:if test="${not empty msg}"><div class="alert-${msg_type} alert">${msg}</div></c:if>
                                <p>请填写详细信息.</p>
                                <form action="/${type}/updateUser" method="post">
                                    <div class="form-group">
                                        <label class="form-control-label text-uppercase" >姓名</label>
                                        <input type="text" value="${user.name}" required name="name" class="form-control" <c:if test="${type == 'teacher'}">disabled</c:if>>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-control-label text-uppercase" >性别</label>
                                        <select class="form-control" required name="sex" <c:if test="${type == 'teacher'}">disabled</c:if>>
                                            <c:if test="${user.sex=='男'}">
                                                <option value="男" selected>男</option>
                                                <option value="女">女</option>
                                            </c:if>
                                            <c:if test="${user.sex=='女'}">
                                                <option value="男">男</option>
                                                <option value="女" selected>女</option>
                                            </c:if>

                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-control-label text-uppercase" >身份证</label>
                                        <input type="text" value="${user.idNumber}" required name="idNumber" class="form-control" <c:if test="${type == 'teacher'}">disabled</c:if>>
                                    </div>
                                    <c:if test="${type == 'user'}">
                                    <div class="form-group">
                                        <label class="form-control-label text-uppercase">所在区域</label>
                                        <input type="text" value="${user.area}" required name="area" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-control-label text-uppercase">详细地址</label>
                                        <input type="text" value="${user.address}" required  name="address" class="form-control">
                                    </div>
                                    </c:if>
                                    <div class="form-group">
                                        <label class="form-control-label text-uppercase">联系电话</label>
                                        <input type="text" value="${user.phone}"  required name="phone" class="form-control">
                                    </div>
                                    <c:if test="${type == 'teacher'}">
                                        <div class="form-group">
                                            <label class="form-control-label text-uppercase">个人描述</label>
                                            <input type="text" value="${user.description}"  required name="description" class="form-control">
                                        </div>
                                    </c:if>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary">提交修改</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
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
