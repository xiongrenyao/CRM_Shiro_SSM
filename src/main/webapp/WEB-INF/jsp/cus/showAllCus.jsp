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
<div class="panel-heading">客户管理列表
    <shiro:hasRole name="2">
    <a class="btn btn-primary" href="javascript:;" onclick="CUST.add()">客户添加</a></div>
</shiro:hasRole>
<div class="panel-body">
    <table class="table table-bordered" width="90%">
        <tr>
            <td>客户ID</td>
            <td>客户名</td>
            <td>地址</td>
            <td>联系人</td>
            <td>电话</td>
            <td>邮箱</td>
            <shiro:hasRole name="2">
                <td>操作</td>
            </shiro:hasRole>
        </tr>
        <c:forEach items="${cusList}" var="c">
            <tr>
                <td>${c.cus.cusId}</td>
                <td>${c.cus.cusName}</td>
                <td>${c.cus.address}</td>
                <td>${c.cus.contact}</td>
                <td>${c.cus.tel }</td>
                <td>${c.cus.email}</td>

                <shiro:hasRole name="2">
                    <td>
                        <a href="javascript:;" onclick="CUST.edit(${c.cus.cusId})">
                            <button class="btn btn-primary">修改</button>
                        </a>&nbsp;
                        <a href="javascript:;" onclick="CUST.remove(${c.cus.cusId})">
                            <button class="btn btn-danger">删除</button>
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
