<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/28
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-bordered" width="500px" style="margin-top: 20px">
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>客户名</td>
        <td>操作</td>
    </tr>
    <c:forEach var="p" items="${list}">
        <tr>
            <td>${p.permId}</td>
            <td>${p.permName}</td>
            <td>${p.permUrl}</td>
            <td>${p.xxId}</td>
            <td>
                <a href="javascript:;">
                    <button class="btn btn-primary">修改</button>
                </a>
                <a href="javascript:;">
                    <button class="btn btn-danger">删除</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
