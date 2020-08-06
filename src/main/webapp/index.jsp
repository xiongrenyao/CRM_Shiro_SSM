<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<link href="${pageContext.request.contextPath}/libs/css/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
        src="${pageContext.request.contextPath}/libs/css/bootstrap-3.3.7-dist/js/jQuery-1.12.4.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/libs/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<%--<script type="text/javascript">--%>
<%--    if (self.location != top.location) {--%>
<%--        top.location = "login.jsp";--%>
<%--    }--%>

<%--</script>--%>
<style>
    .mt50 {
        margin-top: 100px
    }

    .form-group {
        width: 20%;
        margin-left: auto;
        margin-right: auto;
    }

    /* .fdiv{
      background-color: red;

      opacity: 0.5;
   }  */
</style>
<body>
<div class="container-fluid">
    <div class="fdiv">

        <form action="${pageContext.request.contextPath}/login" method="post">

            <div class="form-group mt50">
                用戶名:<input type="text" class="form-control" name="username" placeholder="请输入用户名"/><br>
                密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" class="form-control" name="password"
                                                  placeholder="请输入密码"/><br>
                <select class="form-control" name="time">
                    <option value="0">请选择</option>
                    <option value="1">一天</option>
                    <option value="7">一周</option>
                    <option value="30">一月</option>
                </select>
                <br>
                <input type="submit" class="btn btn-primary" value="登录">&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/emp/toRegiste" class="btn btn-info" type="button">去注册</a>&nbsp;&nbsp;
                <p style="color: red">${msg}</p>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    <%--function toReg() {--%>
    <%--    $.ajax({--%>
    <%--        type:"post",--%>
    <%--        url : "${pageContext.request.contextPath}/emp/toRegister",--%>
    <%--        success:function (result) {--%>
    <%--           $("#right").html(result)--%>
    <%--        }--%>
    <%--    });--%>
    <%--    alert("aaaaa")--%>
    <%--}--%>

</script>
</html>