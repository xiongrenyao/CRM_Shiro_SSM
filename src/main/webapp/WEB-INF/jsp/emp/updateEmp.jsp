<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="sysForm" class="form-horizontal">
    <input name="empId" value="${emp.empId}" hidden="hidden">
    <div class="form-group">
        <label class="col-sm-4 control-label">用户名</label>
        <div class="col-sm-6">
            <input class="form-control required" name="username" id="username" value="${emp.username}">
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">密码</label>
        <div class="col-sm-6">
            <input class="form-control required" name="password" id="password" value="${emp.password}">
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">电话</label>
        <div class="col-sm-6">
            <input class="form-control required" name="tel" id="tel" value="${emp.tel}">
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">姓名</label>
        <div class="col-sm-6">
            <input class="form-control required" name="name" id="name" value="${emp.name}">
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">邮箱</label>
        <div class="col-sm-6">
            <input class="form-control required email" name="email" id="email" value="${emp.email}">
        </div>
        <div class="col-sm-4"></div>
    </div>
</form>


<%--    账号:<input name="username" id="username"><br>--%>
<%--&lt;%&ndash;    密码:<input type="password" name="password" id="password"><br>&ndash;%&gt;--%>
<%--    姓名:<input name="idcard" id="idcard"><br>--%>
<%--    手机:<input name="phone" id="phone"><br>--%>
<%--    邮箱:<input name="email" id="email"><br>--%>
<%--    角色:--%>
<%--    <select  name="roleId">--%>
<%--       <option>请选择</option>--%>
<%--        <c:forEach var="role" items="${roles}">--%>
<%--            <option value="${role.id}">${role.name}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>