<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="height: 100%;width: 100%">
    <div id="rolePermLeft" style="height: 100%;width: 10%;float: left">
        <input id="roleId" name="roleId" hidden="hidden"/>
        <c:forEach items="${roleList}" var="role">
            <div id="roleDiv" style="margin-top: 30px;height: 10px">
                <button class="btn btn-primary" onclick="ROLEPERM.clickRole(${role.roleId})">${role.roleName}</button>
            </div>
        </c:forEach>
    </div>
    <div id="rolePermRight" style="height: 100%;width: 90%;float: left;margin-top: 30px">
        <input id="permId" name="permId" hidden="hidden"/>
        <div id="permDiv" style="margin-top: 30px;height: 10px">
            <c:forEach items="${permList}" var="perm">
                <label style="width: 200px">
                    <input type="checkbox" value="${perm.permId}" onclick="ROLEPERM.checkBox(${perm.permId})"/>
                    <input type="button" class="btn btn-primary" name="permName" value="${perm.permName}"/>
                </label>
            </c:forEach>
        </div>
    </div>
</div>

