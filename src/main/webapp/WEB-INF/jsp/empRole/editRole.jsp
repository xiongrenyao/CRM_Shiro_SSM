<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/6
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="sysForm6" class="form-horizontal">
    <input name="empId" value="${emp.empId}" hidden="hidden"/>
    当前用户为:<input type="text" name="username" value="${emp.username}" readonly="readonly"/><br>
    当前角色为:<input type="text" name="roleName" value="${role.roleName}" readonly="readonly"/><br>
    修改角色为:<select class="form-control" name="roleId">
    <option value="${role.roleId}">${role.roleName}</option>
    <c:forEach items="${roleList}" var="r">
        <option value="${r.roleId}">${r.roleName}</option>
    </c:forEach>
</select>
</form>
</body>
</html>
