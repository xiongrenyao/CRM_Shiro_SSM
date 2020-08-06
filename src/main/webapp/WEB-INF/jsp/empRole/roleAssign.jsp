<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Role" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.pojo.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/29
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    Set<Integer> set = (Set<Integer>) request.getAttribute("empRoles");
    Employee emp = (Employee) request.getAttribute("emp");
    List<Role> roleList = (List<Role>) request.getAttribute("roleList");
%>
<%--<link href="${pageContext.request.contextPath}/css/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/css/bootstrap-3.3.7-dist/js/jQuery-1.12.4.js"></script>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>--%>
<body>
<div class="container-fluid">
    <form class="form-inline">

        <div><input type="submit" class="btn btn-primary" onclick="saveEmpRole()" value="提交"/></div>

        <div class="col-xs-3">
            <input id="empId" value="<%=emp.getEmpId()%>" hidden="hidden">
            用户名:<input class="btn btn-info" type="button" name="username" value="<%=emp.getUsername()%>">
        </div>

        <div id="roleDiv" class="col-xs-8">
            <%
                for (Role role : roleList) {
            %>
            <input type="checkbox" name="roles" value="<%=role.getRoleId()%>"
                    <% if (set.contains(role.getRoleId())) { %>
                   checked
                    <% } %>
            /><input type="button" class="btn btn-primary" value="<%=role.getRoleName()%>"/>
            <%
                }
            %>

        </div>
        <div>

        </div>
    </form>

</div>
</body>
<script>
    function saveEmpRole() {
        var arr = new Array();
        $("#roleDiv").find(":checkbox").each(function () {
            if ($(this).prop("checked")) {
                arr.push($(this).val());
            }
        });
        if (arr.length == 0) {
            alert("请选择");
            return;
        }
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/empRole/roleAss",
            data: {
                empId: $("#empId").val(),
                roles: arr.join()
            },
            success: function (r) {
                alert(r);
                window.location.reload();
            }
        })
    }
</script>
</html>
