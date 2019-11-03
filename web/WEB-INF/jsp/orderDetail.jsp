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
            <li class="sidebar-list-item"><a href="/${type}/toOrderManager" class="sidebar-link text-muted active" ><i class="o-survey-1 mr-3 text-gray"></i><span>家教中心</span></a></li>
            <li class="sidebar-list-item"><a href="#" data-toggle="collapse" data-target="#pages" aria-expanded="false" aria-controls="pages" class="sidebar-link text-muted"><i class="o-user-1 mr-3 text-gray"></i><span>用户</span></a>
                <div id="pages" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item"><a href="/${type}/toSetting" class="sidebar-link text-muted pl-lg-5">修改资料</a></li>
                        <li class="sidebar-list-item"><a href="/${type}/toPassword" class="sidebar-link text-muted pl-lg-5">修改密码</a></li>
                        <li class="sidebar-list-item"><a href="/${type}/toDeposit" class="sidebar-link text-muted pl-lg-5">押金管理</a></li>
                    </ul>
                </div>
            </li>
            <li class="sidebar-list-item"><a href="/${type}/logout" class="sidebar-link text-muted"><i class="o-exit-1 mr-3 text-gray"></i><span>退出登录</span></a></li>
        </ul>
    </div>
    <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">

            <c:if test="${not empty msg}"><div class="alert-${msg_type} alert">${msg}</div></c:if>

            <section class="py-5">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card px-5 py-4">
                            <h2 class="mb-0 d-flex align-items-center" ><span>${order.sub}-${order.level}</span>
                                <c:if test="${order.status == -1}">
                                    <div class="badge badge-dark" style="margin-left: 20px;">已取消</div>
                                </c:if>
                                <c:if test="${order.status == 0}">
                                    <div class="badge badge-secondary" style="margin-left: 20px;">未找到</div>
                                </c:if>
                                <c:if test="${order.status == 1}">
                                    <div class="badge badge-warning" style="margin-left: 20px;">待确认</div>
                                </c:if>
                                <c:if test="${order.status == 2}">
                                    <div class="badge badge-success" style="margin-left: 20px;">已找到</div>
                                </c:if>

                            </h2>
                            <span class="text-muted">发布于：<fmt:formatDate value="${order.pubTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></span>
                            <div class="py-4">
                                <div class="bg-white shadow roundy px-4 py-3 d-flex align-items-center justify-content-between mb-4">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-green"></div>
                                        <div class="text">
                                            <h6 class="mb-0">家教地区</h6><span class="text-black-50">${order.area}</span>
                                        </div>
                                    </div>
                                    <div class="icon bg-green text-white"><i></i></div>
                                </div>
                                <div class="bg-white shadow roundy px-4 py-3 d-flex align-items-center justify-content-between mb-4">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-red"></div>
                                        <div class="text">
                                            <h6 class="mb-0">单次薪资</h6><span class="text-red">￥${order.price}</span>
                                        </div>
                                    </div>
                                    <div class="icon bg-red text-white"><i></i></div>
                                </div>
                                <div class="bg-white shadow roundy px-4 py-3 d-flex align-items-center justify-content-between mb-4">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-blue"></div>
                                        <div class="text">
                                            <h6 class="mb-0">每周次数</h6><span class="text-blue">${order.weekNum}次</span>
                                        </div>
                                    </div>
                                    <div class="icon bg-blue text-white"><i></i></div>
                                </div>
                            </div>
                            <div class="py-5">
                                <h4>家教要求：</h4>
                                ${order.content}
                            </div>
                            <c:if test="${type == 'teacher' && order.teacher.id == user.id && order.status != 0}">
                                <div class="py-5">
                                    <h4>详细信息：</h4>
                                    <c:if test="${order.status == 1}">
                                    <strong>联系人电话：</strong>${order.student.phone}
                                    </c:if>
                                    <c:if test="${order.status == 2}">
                                        <strong>联系人电话：</strong>${order.student.phone}
                                        <br/><strong>家教详细地址：</strong>${order.address}
                                    </c:if>
                                </div>
                            </c:if>
                            <c:if test="${not empty order.teacher}">
                                <a  href="#"
                                    <c:if test="${user.id==order.student.id && type=='user'}">
                                        data-toggle="modal" data-target="#myModal"
                                    </c:if>
                                   class="message card px-5 py-3 mb-4 bg-hover-gradient-primary no-anchor-style">
                                    <div class="row">
                                        <div class="col-lg-3 d-flex align-items-center flex-column flex-lg-row text-center text-md-left"><strong class="h5 mb-0"><fmt:formatDate value="${order.finTime}" pattern="yyyy-MM-dd"></fmt:formatDate></strong><img src="/static/img/avatar-1.jpg" alt="..." style="max-width: 3rem" class="rounded-circle mx-3 my-2 my-lg-0">
                                            <h6 class="mb-0">${order.teacher.name}</h6>
                                        </div>
                                        <div class="col-lg-7">

                                        </div>
                                        <div class="col-lg-2 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                            <div class="bg-blue roundy px-4 py-1 mr-0 mr-lg-3 mt-2 mt-lg-0 text-white exclode">已接取</div>
                                        </div>
                                    </div></a>
                                <div class="modal fade" id="myModal">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">教师信息</h4>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>

                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                姓名:${order.teacher.name}<br/>
                                                性别:${order.teacher.sex}<br/>
                                                职业:${order.teacher.role}<br/>
                                                毕业学校:${order.teacher.school}<br/>
                                                联系电话:${order.teacher.phone}<br/>
                                                描述:${order.teacher.description}<br/>
                                            </div>
                                            <div class="modal-header">
                                                <h4 class="modal-title">近期评价</h4>
                                            </div>
                                            <div class="modal-body">
                                                <c:forEach items="${evalutionList}" var="evalution">
                                                    <div class="col-lg-12"><a class="message card px-5 py-3 mb-4 bg-hover-gradient-primary no-anchor-style">
                                                        <div class="row">
                                                            <div class="col-lg-3 "><img src="/static/img/avatar-1.jpg" alt="..." style="max-width: 3rem" class="rounded-circle mx-3 my-2 my-lg-0">
                                                            </div>
                                                            <div class="col-lg-9 ">
                                                                <p class="mb-0 mt-3 mt-lg-0">${evalution.postContent}</p>
                                                            </div>
                                                        </div></a></div>
                                                </c:forEach>

                                            </div>

                                            <!-- 模态框底部 -->
                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${order.student.id == user.id && order.status == 0 && type == 'user'}">
                                <center>
                                    <a href="#" data-toggle="modal" data-target="#myModal" class="btn btn-primary">取消发布</a>
                                </center>
                                <div class="modal fade" id="myModal">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">确认信息</h4>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>

                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                确定要取消吗？
                                            </div>

                                            <!-- 模态框底部 -->
                                            <div class="modal-footer">
                                                <a href="/user/unPub?id=${order.id}" class="btn btn-primary" >确认</a>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${order.student.id == user.id && order.status == 1 && type == 'user'}">
                                <center>
                                    <a href="/user/confirmOrders?id=${order.id}" data-toggle="modal" data-target="#myModal1" class="btn btn-primary">同意家教</a>&nbsp;<a href="/user/rejuctOrders?id=${order.id}" data-toggle="modal" data-target="#myModal2" class="btn btn-danger">换个家教</a>
                                </center>
                                <div class="modal fade" id="myModal1">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">确认信息</h4>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>

                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                要同意吗？
                                            </div>

                                            <!-- 模态框底部 -->
                                            <div class="modal-footer">
                                                <a href="/user/confirmOrders?id=${order.id}" class="btn btn-primary">同意</a>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <div class="modal fade" id="myModal2">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">确认信息</h4>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>

                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                要拒绝吗？
                                            </div>

                                            <!-- 模态框底部 -->
                                            <div class="modal-footer">
                                                <a href="/user/rejuctOrders?id=${order.id}" class="btn btn-primary">确认</a>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${type == 'teacher' && order.status == 0}">
                                <c:if test="${user.status == 0}">
                                    <center>
                                        <a href="#" class="btn btn-primary" disabled>请先缴纳押金</a>
                                    </center>
                                </c:if>
                                <c:if test="${user.status == 1}">

                                <center>
                                    <a href="#" data-toggle="modal" data-target="#myModal" class="btn btn-primary">接了这单</a>
                                </center>
                                <!-- 模态框 -->
                                <div class="modal fade" id="myModal">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">确认信息</h4>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>

                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                家教地区：${order.area}<br/>
                                                单次薪资：￥${order.price}<br/>
                                                每周次数：${order.weekNum}次<br/>
                                                手续费：￥${order.price * order.weekNum * 0.7}<br/>
                                            </div>

                                            <!-- 模态框底部 -->
                                            <div class="modal-footer">
                                                <a href="/teacher/postOrders?id=${order.id}" class="btn btn-primary" >确认</a>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                </c:if>
                            </c:if>

                            <c:if test="${type == 'teacher' && order.teacher.id == user.id && order.status == 1}">
                                <center>
                                    <a href="#"  data-toggle="modal" data-target="#myModal1"  class="btn btn-primary">取消订单</a>
                                </center>
                                <div class="modal fade" id="myModal1">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">确认信息</h4>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>

                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                确定要取消吗？
                                            </div>

                                            <!-- 模态框底部 -->
                                            <div class="modal-footer">
                                                <a href="/teacher/unPost?id=${order.id}" class="btn btn-primary" >确认</a>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${order.status == 2 && (order.student.id == user.id || order.teacher.id == user.id)}">
                                <center>
                                    <a href="/${type}/addEvalution?id=${order.id}" data-toggle="modal" data-target="#myModal1" class="btn btn-primary">评价订单</a>
                                </center>
                                <div class="modal fade" id="myModal1">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">添加评价</h4>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>
                                            <form action="/${type}/addEvalution" method="post">
                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label class="form-control-label text-uppercase">评价内容</label>
                                                    <textarea type="text" placeholder="请输入评价内容" required name="postContent" class="form-control"></textarea>
                                                </div>
                                                <input type="hidden" name="orderId" value="${order.id}">
                                                <input type="hidden" name="toTeacher" value="${order.teacher.id}">
                                            </div>

                                            <!-- 模态框底部 -->
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-primary" >确认</button>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </c:if>

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
