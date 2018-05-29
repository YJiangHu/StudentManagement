<%--
  Created by IntelliJ IDEA.
  User: Huyuanjiang
  Date: 2018/5/28
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%
            String path = request.getContextPath();
            request.setAttribute("path", path);
        %>
        <!-- 新 Bootstrap 核心 CSS 文件 -->
        <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
        <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
        <script src="${path}/static/js/jquery.min.js"></script>
        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        <script src="${path}/static/js/bootstrap.min.js"></script>
    </head>
<body>

</body>
</html>
