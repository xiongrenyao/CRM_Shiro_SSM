var CUST = {
    list: function () {
        var url = "/cus/showAll";
        AJAX.html(url, function (html) {
            $("#right").html(html);
        })
    },

    list2: function () {
        var url = "/cus/showAll3";
        //var url ="/cus/page";
        AJAX.html(url, function (html) {
            $("#right").html(html);
        })
    },

    add: function () {
        var url = "/cus/add";
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                shade: "0.8",
                title: "客户添加",
                btn: ['保存'],
                yes: function (index, layero) {
                    CUST.save();
                }
            });
        })
    },
    save: function () {
        var url = "/cus/save";
        AJAX.post(url, $("#sysForm3").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();//关闭添加框
                CUST.list();
                layer.alert("添加成功");
            } else {
                layer.alert(result.message);
            }
        });
    },

    edit: function (id) {
        var url = "/cus/edit?id=" + id;
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                title: "客户更新",
                btn: ['更新'],
                yes: function (index, layero) {
                    CUST.update();
                }
            });
        })
    },

    update: function () {
        var url = "/cus/update";
        AJAX.post(url, $("#sysForm3").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();//关闭添加框
                CUST.list();
                layer.alert("修改成功");
            } else {
                layer.alert(result.message);
            }
        });

    },

    remove: function (id) {
        var url = "/cus/delete";
        layer.confirm("确认删除此记录？", function () {
            AJAX.post(url, {cusId: id}, function (result) {
                if (result.status == 200) {
                    layer.closeAll();
                    CUST.list();
                    layer.alert("删除成功");
                } else {
                    layer.alert(result.message);
                }
            })

        });
    }
}