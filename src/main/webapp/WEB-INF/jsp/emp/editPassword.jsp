<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="sysForm8" class="form-horizontal">
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
            <input class="form-control required" name="password" id="password">
        </div>
        <div class="col-sm-4"></div>
    </div>
    <input type="button" class="btn btn-primary" onclick="EMP.updatePass()" value="提交"/>
</form>