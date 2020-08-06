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
<script type="text/javascript">
    if (self.location != top.location) {
        top.location = "login.jsp";
    }

</script>
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
        <form action="${pageContext.request.contextPath}/emp/registe" method="post">

            <div class="form-group mt50">
                用戶名:<input type="text" class="form-control" name="username" placeholder="请输入用户名"/><br>
                密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" class="form-control" name="password"
                                                  placeholder="请输入密码"/><br>
                电&nbsp;&nbsp;&nbsp;&nbsp;话:<input type="text" class="form-control" name="tel" placeholder="请输入电话"/><br>
                姓&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" class="form-control" name="name" placeholder="请输入姓名"/><br>
                邮&nbsp;&nbsp;&nbsp;&nbsp;箱:<input type="email" class="form-control" name="email"
                                                  placeholder="请输入邮箱"/><br>
                <br>
                <input type="submit" class="btn btn-primary" value="提交">&nbsp;&nbsp;
            </div>
        </form>
    </div>
</div>
</body>
</html>