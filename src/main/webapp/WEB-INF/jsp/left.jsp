<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div id="logout" style="width: 60px">
    <a class="btn btn-primary btn-block" href="${pageContext.request.contextPath}/loginout">退出</a>
</div>
<shiro:hasRole name="1">
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="EMP.list()">专员列表</a>
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="CUST.list2()">客户列表</a>
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="EMP.editPass()">修改密码</a>
</shiro:hasRole>

<shiro:hasRole name="2">
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="CUST.list()">客户列表</a>
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="INFO.list2(${LoginUser.empId})">拜访列表</a>
</shiro:hasRole>

<%--<a class="btn btn-primary btn-block" href="javascript:;" onclick="INFO.list()">拜访列表</a>--%>
<shiro:hasRole name="3">
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="EMP.list()">专员列表</a>
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="ROLE.list()">角色列表</a>
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="PERM.list()">权限列表</a>
    <a class="btn btn-primary btn-block" href="javascript:;" onclick="ROLEPERM.show()">权限分配</a>
</shiro:hasRole>

