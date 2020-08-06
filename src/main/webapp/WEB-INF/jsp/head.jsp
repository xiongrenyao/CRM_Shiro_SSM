<%@ page import="com.pojo.Role" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/3
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>倪莫问客户管理系统</title>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/libs/css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/libs/css/bootstrap-table/dist/bootstrap-table.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/libs/css/web.css">
<script>
    var ctx = "${pageContext.request.contextPath}";
</script>
<%
    double d = new java.util.Random().nextDouble();
%>
<%--<script src="${pageContext.request.contextPath}/libs/js/jquery-validation/dist/jquery.validate.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/libs/js/jquery-validation/dist/localization/messages_zh.js"></script>--%>
<script src="${pageContext.request.contextPath}/libs/css/bootstrap-3.3.7-dist/js/jQuery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath}/libs/css/bootstrap-table/dist/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/libs/css/bootstrap-table/dist/locale/bootstrap-table-zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/libs/js/My97DatePicker/WdatePicker.js"></script>
<script src="${pageContext.request.contextPath}/libs/js/My97DatePicker/lang/zh-cn.js"></script>
<script src="${pageContext.request.contextPath}/libs/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/libs/js/common.js?r=<%=d%>"></script>
<script src="${pageContext.request.contextPath}/libs/js/emp.js?r=<%=d%>"></script>
<script src="${pageContext.request.contextPath}/libs/js/cust.js?r=<%=d%>"></script>
<script src="${pageContext.request.contextPath}/libs/js/visit.js?r=<%=d%>"></script>
<script src="${pageContext.request.contextPath}/libs/js/empRole.js?r=<%=d%>"></script>
<script src="${pageContext.request.contextPath}/libs/js/rolePerm.js?r=<%=d%>"></script>
<script src="${pageContext.request.contextPath}/libs/js/role.js?r=<%=d%>"></script>
<script src="${pageContext.request.contextPath}/libs/js/perm.js?r=<%=d%>"></script>
