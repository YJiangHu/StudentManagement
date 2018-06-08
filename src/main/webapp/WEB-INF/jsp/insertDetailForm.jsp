<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/5/30
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="head.jsp"%>
    <title>增加信息</title>
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
    <h2>添加选课信息</h2>
    <br>
    <br>
    <form class="form-inline" action="${path}/detail/insertDetail" method="post">
        <div class="form-group">
            <input type="hidden" name="Sno" value="${sno}">
            <label for="inputCourseName">课程名：</label>
            <select class="form-control" name="Cno" id="inputCourseName">
                <c:forEach items="${courselist}" var="courseitem">
                    <option value="${courseitem.id}">${courseitem.name}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            <label for="inputGrade">成绩：</label>
            <input type="text" class="form-control" id="inputGrade" name="Grade">
            <br>
            <br>
            <p align="center">
                <button type="submit" class="btn btn-success">提交</button>
                <button type="button" class="btn btn-primary" onclick="window.location.href='${path}/studentmanager/list'">
                    取消
                </button>
            </p>
            <c:if test="${!empty errormsg}">
                <c:forEach items="${errormsg}" var="error">
                    <p style="color: #ac2925">${error}</p>
                </c:forEach>
            </c:if>
        </div>
    </form>
</div>
</body>
</html>
