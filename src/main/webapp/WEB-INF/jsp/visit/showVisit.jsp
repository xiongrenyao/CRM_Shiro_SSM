<%@ page contentType="text/html;charset=UTF-8" %>
<div class="panel panel-default">
    <div class="panel-heading">拜访信息列表
        <%--        <a class="btn btn-primary btn-xs" href="javascript:;" onclick="INFO.add()">添加</a>--%>
        <%--        <a class="btn btn-primary btn-xs" href="javascript:;" onclick="INFO.edit()">编辑</a>--%>
        <%--        <a class="btn btn-primary btn-xs" href="javascript:;" onclick="INFO.remove()">删除</a>--%>
        <div class="panel-body">
            <table id="bootstrap_table"></table>
        </div>
    </div>

    <script>
        $(function () {
            initTable("/visit/page", visitColums);
        });
    </script>
</div>