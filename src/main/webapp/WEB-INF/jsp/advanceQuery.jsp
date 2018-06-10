<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/6/10
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="head.jsp"%>
    <title>高级查询</title>
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
<div class="col-xs-6 col-md-4 col-center-block">
    <h2>学生信息高级查询</h2>
    <br>
    <br>
    <form class="form-inline" action="${path}/studentmanager/queryStudent" method="post">
        <div class="form-group">
            <label for="inputId">学号：</label>
            <input type="text" class="form-control" id="inputId" name="id" placeholder="请输入纯数字学号">
            <br>
            <br>
            <label for="inputName">姓名：</label>
            <input type="text" class="form-control" id="inputName" name="name">
            <br>
            <br>
            <label for="inputClazz">性别：</label>
            <select class="form-control" name="clazz" id="inputClazz">
                <option> </option>
                <c:forEach items="${clazzSet}" var="clazz">
                    <option>${clazz}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            <p align="center">
                <button type="submit" class="btn btn-success">提交</button>
                <button type="button" class="btn btn-primary" onclick="window.history.back(-1);">
                    取消
                </button>
            </p>
            <c:if test="${!empty msg}">
                <p style="color: #ff1217">${msg}</p>
            </c:if>
        </div>
    </form>
</body>
</html>
