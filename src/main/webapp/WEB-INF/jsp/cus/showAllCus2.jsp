<%@ page contentType="text/html;charset=UTF-8" %>
<div class="panel panel-default">
    <div class="panel-heading">
        客户管理
        <a class="btn btn-primary btn-xs" href="javascript:;" onclick="CUST.add()">添加</a>
        <a class="btn btn-primary btn-xs" href="javascript:;" onclick="CUST.edit()">编辑</a>
        <a class="btn btn-primary btn-xs" href="javascript:;" onclick="CUST.remove()">删除</a>
        <a class="btn btn-primary btn-xs" href="javascript:;" onclick="CUST.toChange()">转移</a>
        <a class="btn btn-primary btn-xs" href="javascript:;" onclick="CUST.toShare()">共享</a>
    </div>
    <div class="panel-body">
        <table id="bootstrap_table"></table>
    </div>
</div>
<script>
    $(function () {
        initTable("/cus/page", custColums);
    });
</script>