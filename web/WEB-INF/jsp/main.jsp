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
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

    <!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>科目</th>
                    <th>年级</th>
                    <th>状态</th>
                    <th>发布时间</th>
                    <th>完成时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.sub}</td>
                        <td>${item.level}</td>
                        <td>${item.status}</td>
                        <td><fmt:formatDate value="${item.pubTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        <td><fmt:formatDate value="${item.finTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
