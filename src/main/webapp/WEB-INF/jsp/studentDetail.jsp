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
    <c:if test="${empty student}">
        <h3 style="color: #ac2925" align="center">没有此学生</h3>
    </c:if>
    <c:if test="${!empty student}">
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
    </c:if>
    <br>
    <br>

    <c:if test="${!empty list}">
    <h2 align="center">成绩信息</h2>
    <div class="col-xs-6 col-md-7 col-center-block">
        <br>
        <form name="studentitem" action="" method="get">
            <button type="button" class="btn btn btn-success" onclick="window.location.href='${path}/studentmanager/list'">
                <span class="glyphicon glyphicon-chevron-left">返回列表</span>
                <span>-</span>
            </button>
            <button type="button" class="btn btn-primary" onclick="window.location.href='${path}/detail/insert?id=${student.id}'">添加</button>
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
                        <td>
                            <button type="button" class="btn btn-danger" id="delete"
                                    onclick="window.location.href='${path}/detail/delete?cno=${studentGrade.course.id}&&sno=${student.id}'">删除</button>
                            <button type="button" class="btn btn-info"
                                    onclick="window.location.href='${path}/detail/edit?' +
                                            'cno=${studentGrade.course.id}&&sno=${student.id}'">编辑</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
    </c:if>
    <c:if test="${empty list}">
        <div class="ss" align="center">
            <h3 style="color: #ac2925">没有相关课程信息</h3>
            <button type="button" class="btn btn btn-success" onclick="window.location.href='${path}/studentmanager/list?id=${id}'">
                <span class="glyphicon glyphicon-chevron-left">返回列表</span>
                <span>-</span>
            </button>
        </div>
    </c:if>
</body>
</html>
