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
<input type="button" class="btn btn-primary" value="添加角色" onclick="ROLE.add()"/>
<table class="table table-bordered" width="500px" style="margin-top: 20px">
    <tr>
        <td>编号</td>
        <td>角色名</td>
        <td>操作</td>
    </tr>
    <c:forEach var="r" items="${list}">
        <tr>
            <td>${r.roleId}</td>
            <td>${r.roleName}</td>
            <td>
                <a href="#" onclick="ROLE.edit(${r.roleId})">
                    <button class="btn btn-primary">修改</button>
                </a>
                <a href="#" onclick="ROLE.remove(${r.roleId})">
                    <button class="btn btn-danger">删除</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
