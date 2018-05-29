<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/5/29
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
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
<h2>添加学生信息</h2>
<br>
<br>
    <form class="form-inline" action="/studentmanager/insertStudent" method="post">
        <div class="form-group">
            <label for="inputId">学号：</label>
            <input type="text" class="form-control" id="inputId" name="id">
            <br>
            <br>
            <label for="inputName">姓名：</label>
            <input type="text" class="form-control" id="inputName" name="name">
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
            <input type="text" class="form-control" id="inputClass" name="clazz">
            <br>
            <br>
            <label for="inputPhone">电话：</label>
            <input type="text" class="form-control" id="inputPhone" name="phone">
            <br>
            <br>
            <%--<label>性别</label>
            <label class="radio-inline">
                <input type="radio" name="studentSex" id="male" value="男"> 男
            </label>
            <label class="radio-inline">
                <input type="radio" name="studentSex" id="famale" value="女"> 女
            </label>--%>
            <div class="col-xs-6 col-md-4 col-center-block">
            <button type="submit" class="btn btn-success">提交</button>
            <button type="button" class="btn btn-primary" onclick="window.location.href='/studentmanager/list'">
                取消
            </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
