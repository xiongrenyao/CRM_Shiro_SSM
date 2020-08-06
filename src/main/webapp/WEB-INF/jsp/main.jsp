<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/3
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
<body>
<div id="web-container">
    <div id="left">
        <%@include file="/WEB-INF/jsp/left.jsp" %>
    </div>
    <div id="right"><h2>欢迎<font color="red">${LoginUser.username}</font>使用倪莫问客户管理系统</h2></div>
    <div>${info}</div>
    <div id="clear"></div>
</div>
</body>
</html>
