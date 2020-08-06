<%@ page import="com.pojo.EmpCus" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/5
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="form-group-lg" id="changeForm">
    <%--    <input class="form-control" value="${emp.empId}" hidden="hidden" />--%>
    专员:<input class="form-control" type="text" name="cusName" value="${emp.username}"><br>
    客户:<select class="form-control" name="cusId">
    <option value="0">请选择</option>
    <c:forEach items="${empCusList}" var="ec">
        <option value="${ec.cus.cusId}">${ec.cus.cusName}</option>
    </c:forEach>
</select><br>
    接收专员:<select class="form-control" name="empId">
    <option value="0">请选择</option>
    <c:forEach items="${empList}" var="e">
        <option value="${e.empId}">${e.username}</option>
    </c:forEach>
</select>
</form>
