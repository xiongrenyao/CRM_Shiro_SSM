var ajax_timeout = 15 * 1000;
var layerLoadIndex;
$.ajaxSetup({
    beforeSend: function () {
        layerLoadIndex = layer.load(2, {
            time: ajax_timeout
        });
    },

    complete: function () {
        layer.close(layerLoadIndex);
    },
    cache: false,

    error: function (xhr, status, error) {
        if ("timeout" == status) {
            layer.alert("请求超时！");
        } else if ("error" == status) {
            layer.alert("请求错误！");
        } else if ("abort" == status) {
            layer.alert("请求终止！");
        } else if ("parsererror" == status) {
            layer.alert("解析错误！");
        } else {
            layer.alert("未知错误！")
        }
    },
    global: false,
    timeout: ajax_timeout
});

function doAjax(method, dataType, url, data, successFunction) {
    $.ajax({
        data: data,
        dataType: dataType,
        success: successFunction,
        type: method,
        url: ctx + url
    });
}

//初始化ajax
var AJAX = {
    html: function (url, successFunction) {
        doAjax("GET", "html", url, {}, successFunction);
    },
    get: function (url, successFunction) {
        doAjax("GET", "json", url, data, successFunction);
    },
    post: function (url, data, successFunction) {
        doAjax("POST", "json", url, data, successFunction);
    }
}


function initTable(url, colums) {
    $("#bootstrap_table").bootstrapTable({
        method: 'get',
        url: ctx + url,//请求路径
        striped: true, //是否显示行间隔色
        pageNumber: 1, //初始化加载第一页
        pagination: true,//是否分页
        height: 500,
        sidePagination: 'server',//server:服务器端分页|client：前端分页
        pageSize: 5,//单页记录数
        pageList: [5, 10, 20, 30],//可选择单页记录数
        showRefresh: true,//刷新按钮
        queryParams: function (params) {//上传服务器的参数
            //如果是在服务器端实现分页，limit、offset这两个参数是必须的
            var temp = {
                // 每页显示数量
                maxResult: params.limit,
                // SQL语句起始索引
                first: params.offset
            };
            return temp;
        },

        columns: colums
    })
}

function getCheckedItem() {
    var container = "bootstrap_table";
    if (arguments.length == 1) {
        container = arguments[0];
    }
    var arr = new Array();
    //拿到所有type=checkbox的input对象
    $("#" + container).find(":checkbox").each(function () {
        if ($(this).prop("checked")) {
            arr.push($(this).val());
        }
    });
    return arr;
}

var empColums = [{
    title: 'USERNAME',
    field: 'username'
}, {
    title: 'PASSWORD',
    field: 'password',
}, {
    title: 'TEL',
    field: 'tel'
}, {
    title: 'NAME',
    field: 'name'
}, {
    title: 'EMAIL',
    field: 'email'
}, {
    title: '操作',
    field: 'empId',
    formatter: function (value) {
        return "<a class=\"btn btn-primary\" href=\"javascript:;\" onclick=\"EMP.edit(" + value + ")\" >修改</a>" +
            "<a class=\"btn btn-primary\" href=\"javascript:;\" onclick=\"EMP.remove(" + value + ")\" >删除</a>"
    }
}];


var custColums = [{
    title: 'CHECK',
    field: 'id',
    formatter: function (id) {
        return "<div class='checkbox'><label><input type='checkbox' value='" + id + "'></label>"
    }
}, {
    title: '单位名称',
    field: 'cusName'
}, {
    title: '地址',
    field: 'address',
}, {
    title: '联系人',
    field: 'contact'
}, {
    title: '电话',
    field: 'tel'
}, {
    title: '邮箱',
    field: 'email'
}, {
    title: '操作',
    field: 'cusId',
    formatter: function (value) {
        return "<a class=\"btn btn-primary\" href=\"javascript:;\" onclick=\"CUST.edit(" + value + ")\" >修改</a>" +
            "<a class=\"btn btn-primary\" href=\"javascript:;\" onclick=\"CUST.remove(" + value + ")\" >删除</a>"
    }
}];


var visitColums = [{
    title: 'CHECK',
    field: 'id',
    formatter: function (id) {
        return "<div class='checkbox'><label><input type='checkbox' value='" + id + "'></label>"
    }
}, {
    title: '公司名称',
    field: 'cusName'
}, {
    title: '联系人',
    field: 'contact'
}, {
    title: '电话',
    field: 'tel'
}, {
    title: '员工',
    field: 'name'
}, {
    title: '拜访时间',
    field: 'date'
}, {
    title: '拜访记录',
    field: 'content'
}]
