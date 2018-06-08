<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/5/30
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="head.jsp"%>
    <title>修改选课信息</title>
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
    <h2>修改选课信息</h2>
    <br>
    <br>
    <form class="form-inline" action="${path}/detail/editDetail" method="post">
        <div class="form-group">
            <input type="hidden" name="cno" value="${studentGrade.sc.cno}">
            <input type="hidden" name="sno" value="${studentGrade.sc.sno}">
            <label for="inputGrade">成绩：</label>
            <input type="text" class="form-control" id="inputGrade" name="grade"  value="${studentGrade.sc.grade}">
            <br>
            <br>
            <p align="center">
                <button type="submit" class="btn btn-success">提交</button>
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" onclick="window.location.href='${path}/detail/list'">取消</button>
            </p>
        </div>
    </form>
</div>
</body>
</html>
