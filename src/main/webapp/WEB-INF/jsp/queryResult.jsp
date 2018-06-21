<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/6/10
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="head.jsp"%>
    <title>查询结果</title>
    <style>
        .col-center-block {
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<br>
<br>
<h2 align="center">查询结果</h2>
<div class="col-xs-6 col-md-7 col-center-block">
    <br>
    <button type="button" class="btn btn btn-success" onclick="window.location.href='${path}/studentmanager/list'">
        <span class="glyphicon glyphicon-chevron-left">返回列表</span>
        <span>-</span>
    </button>

    <br>
    <br>
    <table class="table table-striped table table-hover table table-bordered">
        <tr >
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>班级</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="student">
            <tr>
                <td><a href="${path}/detail/list?id=${student.id}"> ${student.id}</a></td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td>${student.clazz}</td>
                <td>${student.phone}</td>
                <td><button type="button" class="btn btn-danger" id="delete" onclick="window.location.href='${path}/studentmanager/delete?id=${student.id}'">删除</button>
                    <button type="button" class="btn btn-info" onclick="window.location.href='${path}/studentmanager/edit?id=${student.id}'">编辑</button></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
