<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/3
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="panel-heading">用户管理列表 <a class="btn btn-primary" href="javascript:;" onclick="EMP.add()">用户添加</a></div>
<div class="panel-body">
    <table class="table table-bordered" width="90%">
        <tr>
            <td>用户ID</td>
            <td>用户名</td>
            <td>密码</td>
            <td>电话</td>
            <td>姓名</td>
            <td>邮箱</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${empList}" var="e">
            <tr>
                <td>${e.empId}</td>
                <td>${e.username}</td>
                <td>${e.password}</td>
                <td>${e.tel}</td>
                <td>${e.name}</td>
                <td>${e.email}</td>
                <shiro:hasAnyRoles name="1">
                    <td>
                        <a href="javascript:;" onclick="EMP.edit(${e.empId})">
                            <button class="btn btn-primary">修改</button>
                        </a>&nbsp;
                        <a href="javascript:;" onclick="EMP.remove(${e.empId})">
                            <button class="btn btn-danger">删除</button>
                        </a>
                        <a href="javascript:;" onclick="EMP.change(${e.empId})">
                            <button class="btn btn-danger">转移</button>
                        </a>
                    </td>
                </shiro:hasAnyRoles>
                <shiro:hasRole name="3">
                    <td>
                        <a href="javascript:;" onclick="EMPROLE.edit(${e.empId})">
                            <button class="btn btn-danger">角色修改</button>
                        </a>
                    </td>
                </shiro:hasRole>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>

</script>
</html>
