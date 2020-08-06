var INFO = {
    // list:function () {
    //     var url ="/visit/page";
    //     AJAX.html(url,function (html) {
    //         $("#right").html(html)
    //     })
    // },

    list2: function () {
        var url = "/visit/showById";
        AJAX.html(url, function (html) {
            $("#right").html(html)
        })
    },

    add: function () {
        var url = "/visit/add";
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                shade: "0.8",
                title: "拜访添加",
                btn: ['保存'],
                yes: function (index, layero) {
                    INFO.save();
                }
            });
        })
    },

    save: function () {
        var url = "/visit/save";
        AJAX.post(url, $("#sysForm2").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();//关闭添加框
                layer.alert("添加成功");
                INFO.list2()
            } else {
                layer.alert(result.message);
            }
        });
    },

    edit: function (id) {
        var url = "/visit/edit?id=" + id;
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                shade: "0.8",
                title: "拜访记录更新",
                btn: ['更新'],
                yes: function (index, layero) {
                    INFO.update();
                }
            });
        })

    },

    update: function () {
        var url = "/visit/update";
        AJAX.post(url, $("#sysForm2").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();//关闭添加框
                INFO.list2();
                layer.alert("更新成功");
            } else {
                layer.alert(result.message);
            }
        });
    },

    remove: function (id) {
        var url = "/visit/delete?id=" + id;
        layer.confirm("确定要删除此记录？", function () {
            AJAX.post(url, $("#sysForm2"), function (result) {
                if (result.status == 200) {
                    layer.closeAll();//关闭添加框
                    INFO.list2();
                    layer.alert("删除成功");
                } else {
                    layer.alert(result.message);
                }
            });
        })
    }
}