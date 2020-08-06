<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="panel-heading">客户拜访列表 <a class="btn btn-primary" href="javascript:;" onclick="INFO.add()">拜访记录添加</a></div>
<div class="panel-body">
    <table class="table table-bordered" width="90%">
        <tr>
            <td>拜访ID</td>
            <td>客户单位</td>
            <td>联系人</td>
            <td>员工名</td>
            <td>拜访内容</td>
            <td>时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="v">
            <tr>
                <td>${v.id}</td>
                <td>${v.cus.cusName}</td>
                <td>${v.cus.contact}</td>
                <td>${v.emp.name}</td>
                <td>${v.content}</td>
                <td>${v.date }</td>
                <td>
                    <a href="javascript:;" onclick="INFO.edit(${v.id})">
                        <button class="btn btn-primary">修改</button>
                    </a>&nbsp;
                    <a href="javascript:;" onclick="INFO.remove(${v.id})">
                        <button class="btn btn-danger">删除</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>

</script>
</html>
