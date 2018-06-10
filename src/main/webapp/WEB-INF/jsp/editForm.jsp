<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/5/29
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="head.jsp"%>
    <title>修改信息</title>
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
    <h2>修改学生信息</h2>
    <br>
    <br>
    <form class="form-inline" action="${path}/studentmanager/editStudent" method="post">
        <div class="form-group">
            <!-- 隐藏域用于标识正在修改的学生学号-->
            <input type="hidden" name="id" value="${student.id}">
            <label for="inputName">姓名：</label>
            <input type="text" class="form-control" id="inputName" name="name" value="${student.name}">
            <br>
            <br>
            <label for="inputSex">性别：</label>
            <select class="form-control" name="sex" id="inputSex">
                <option>男</option>
                <option>女</option>
            </select>
            <br>
            <br>
            <label for="inputClass">班级：</label>
            <input type="text" class="form-control" id="inputClass" name="clazz"  value="${student.clazz}">
            <br>
            <br>
            <label for="inputPhone">电话：</label>
            <input type="text" class="form-control" id="inputPhone" name="phone"  value="${student.phone}">
            <br>
            <br>
            <p align="center">
            <button type="submit" class="btn btn-success">提交</button>
            &nbsp;&nbsp;<button type="button" class="btn btn-primary" onclick="window.history.back(-1);">取消</button>
            </p>
            <c:if test="${!empty errormsg}" >
                <c:forEach items="${errormsg}" var="error">
                    <p style="color: #ac2925">${error}</p>
                </c:forEach>
            </c:if>
        </div>
    </form>
</div>
</body>
</html>
