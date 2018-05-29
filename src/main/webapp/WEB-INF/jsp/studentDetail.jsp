<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/5/28
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="head.jsp"%>
    <title>成绩信息</title>
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
    <div class="col-xs-6 col-md-6 col-center-block">
        <h2 align="center">学生信息</h2>
        <table class="table table-bordered">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>班级</th>
                <th>电话</th>
            </tr>
            <tr class="success">
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td>${student.clazz}</td>
                <td>${student.phone}</td>
            </tr>
        </table>
    </div>
    <br>
    <br>
    <h2 align="center">成绩信息</h2>
    <div class="col-xs-6 col-md-7 col-center-block">
        <button type="button" class="btn btn btn-success" onclick="window.location.href='/studentmanager/list'">
            <span class="glyphicon glyphicon-chevron-left">返回列表</span>
            <span>-</span>
        </button>
        <br>
        <form name="studentitem" action="" method="get">
        <table class="table table-striped table table-hover table table-bordered">
            <tr>
                <th>课程号</th>
                <th>课程名</th>
                <th>成绩</th>
                <th>学分</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="studentGrade">
                <tr>
                    <td>${studentGrade.course.id}</td>
                    <td>${studentGrade.course.name}</td>
                    <td>${studentGrade.sc.grade}</td>
                    <td>${studentGrade.course.credit}</td>
                    <td><button type="button" class="btn btn-danger" id="delete">删除</button> <%--onclick="window.location.href='/manager/deleteStudent/${student.studentNo}'"--%>
                        <button type="button" class="btn btn-info" <%--onclick="window.location.href='/manager/editStudent?id=${student.studentNo}'"--%>>编辑</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </form>
    </div>
</body>
</html>
