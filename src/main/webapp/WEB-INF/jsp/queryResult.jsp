<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/5/28
  Time: 19:29
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
        <button type="button" class="btn btn btn-success" onclick="window.location.href='/studentmanager/list'">
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
            <c:forEach items="${pageInfo.list}" var="student">
                <tr>
                    <td><a href="/studentmanager/detail?id=${student.id}"> ${student.id}</a></td>
                    <td>${student.name}</td>
                    <td>${student.sex}</td>
                    <td>${student.clazz}</td>
                    <td>${student.phone}</td>
                    <td><button type="button" class="btn btn-danger" id="delete" onclick="window.location.href='/studentmanager/delete?id=${student.id}'">删除</button>
                        <button type="button" class="btn btn-info" onclick="window.location.href='/studentmanager/edit?id=${student.id}'">编辑</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <!-- 信息 -->
    <div class = "row">
        <!-- 分页文字信息 -->
        <div class="col-md-6" align="right">

            当前第 <mark><span class="text-danger">${ pageInfo.pageNum } </span></mark>页 ,
            总 <mark><span class="text-danger">${pageInfo.pages }</span></mark> 页,
            总 <mark><span class="text-danger">${ pageInfo.total }</span></mark> 条记录
        </div>
        <!-- 分页条信息 -->
        <div class="col-md-6" >
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${path}/studentmanager/list?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li>
                            <a href="${path}/studentmanager/list?pn=${pageInfo.pageNum-1 }" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${ pageInfo.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num==pageInfo.pageNum }">
                            <li class="active"><a href="#">${page_Num }</a></li>
                        </c:if>
                        <c:if test="${page_Num!=pageInfo.pageNum }">
                            <li ><a href="${path}/studentmanager/list?pn=${page_Num }">${page_Num }</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage }">
                        <li>
                            <a href="${path}/studentmanager/list?pn=${pageInfo.pageNum+1 }" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${path}/studentmanager/list?pn=${pageInfo.pages}">末页</li>
                </ul>
            </nav>
        </div>
    </div>
</body>
</html>
