<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/28
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="panel-heading"><a class="btn btn-primary" onclick="PERM.add()">权限添加</a></div>
<table class="table table-bordered" id="permListPage" width="500px" style="margin-top: 20px">
    <tr>
        <td>编号</td>
        <td>权限名</td>
        <td>权限路径</td>
        <td>操作</td>
    </tr>
    <%--    <c:forEach var="p" items="${list}">--%>
    <%--        <tr>--%>
    <%--            <td>${p.permId}</td>--%>
    <%--            <td>${p.permName}</td>--%>
    <%--            <td>${p.permUrl}</td>--%>
    <%--            <td>${p.xxId}</td>--%>
    <%--            <td>--%>
    <%--                <shiro:hasRole name="3">--%>
    <%--                    <a href="javascript:;" onclick="PERM.edit(${p.permId})"><button class="btn btn-primary">修改</button></a>--%>
    <%--                    <a href="javascript:;" onclick="PERM.remove(${p.permId})"><button class="btn btn-danger">删除</button></a>--%>
    <%--                </shiro:hasRole>--%>
    <%--            </td>--%>
    <%--        </tr>--%>
    <%--    </c:forEach>--%>
</table>
</body>
<script>
    var currentPage = 1;
    var pageSize = 5;
    var totalPage = 0;
    showListByPage();    //第一次执行
    function showListByPage() {
        $("#permListPage tr:gt(0)").remove();
        $.ajax({
            type: "POST",
            data: {
                "currentPage": currentPage,
                "pageSize": pageSize
            },
            dataType: "json",
            url: ctx + "/perm/showAllByPage",
            success: function (result) {
                var list = result[0];
                if (list.length == 0) {
                    $("#permListPage").append("<tr><td colspan='6' align='center'><h3>没有记录</h3></td></tr>");
                }
                totalPage = result[1];
                for (var i = 0; i < list.length; i++) {
                    $("#permListPage").append("<tr>\n" +
                        "            <td>" + list[i].permId + "</td>\n" +
                        "            <td>" + list[i].permName + "</td>\n" +
                        "            <td>" + list[i].permUrl + "</td>\n" +
                        "            <td>\n" +
                        "                <shiro:hasRole name='3'>" +
                        "                    <a href=\"javascript:;\" onclick=\"PERM.edit(" + list[i].permId + ")\"><button class=\"btn btn-primary\">修改</button></a>\n" +
                        "                    <a href=\"javascript:;\" onclick=\"PERM.remove(" + list[i].permId + ")\"><button class=\"btn btn-danger\">删除</button></a>\n" +
                        "                </shiro:hasRole>\n" +
                        "            </td>\n" +
                        "        </tr>");
                }
                $("#permListPage").append("<tr><td align='center' colspan='8'>" +
                    "<a href='javascript:;' onclick='firstPage()'>首页</a>&nbsp;&nbsp;" +
                    "<a href='javascript:;' onclick='upPage()'>上一页</a>&nbsp;&nbsp;" +
                    "<a href='javascript:;'>第" + currentPage + "页</a>/" +
                    "<a href='javascript:;'>共" + totalPage + "页</a>&nbsp;&nbsp;" +
                    "<a href='javascript:;' onclick='nextPage()'>下一页</a>&nbsp;&nbsp;" +
                    "<a href='javascript:;' onclick='lastPage()'>尾页</a><td></tr>");
            }
        })
    }

    function firstPage() {
        currentPage = 1;
        showListByPage();
    }

    function upPage() {
        if (currentPage == 1) {
            alert("已经是第一页");
        } else {
            currentPage -= 1;
            showListByPage();
        }
    }

    function lastPage() {
        currentPage = totalPage;
        showListByPage();
    }

    function nextPage() {
        if (currentPage == totalPage) {
            alert("已经是最后页");
        } else {
            currentPage += 1;
            showListByPage();
        }
    }
</script>

</html>
