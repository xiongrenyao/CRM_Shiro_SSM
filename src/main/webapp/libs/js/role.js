var ROLE = {
    list: function () {
        var url = "/role/showAll";
        AJAX.html(url, function (html) {
            $("#right").html(html);
        })
    },

    add: function () {
        var url = "/role/add";
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                shade: "0.8",
                title: "角色添加",
                btn: ['保存'],
                yes: function (index, layero) {
                    ROLE.save();
                }
            });
        })
    },

    save: function () {
        var url = "/role/save";
        AJAX.post(url, $("#sysForm4").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();//关闭添加框
                ROLE.list();
                layer.alert("添加成功");
            } else {
                layer.alert(result.message);
            }
        });

    },

    edit: function (id) {
        var url = "/role/edit?roleId=" + id;
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                title: "角色更新",
                btn: ['更新'],
                yes: function (index, layero) {
                    ROLE.update();
                }
            });
        })
    },

    update: function () {
        var url = "/role/update";
        AJAX.post(url, $("#sysForm4").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();//关闭添加框
                ROLE.list();
                layer.alert("修改成功");
            } else {
                layer.alert(result.message);
            }
        });

    },

    remove: function (id) {
        var url = "/role/delete";
        layer.confirm("确认删除此记录？", function () {
            AJAX.post(url, {roleId: id}, function (result) {
                if (result.status == 200) {
                    layer.closeAll();
                    ROLE.list();
                    layer.alert("删除成功");
                } else {
                    layer.alert(result.message);
                }
            })

        });
    }
    //
    // change:function (id) {
    //     var url = "/emp/change?empId="+id;
    //     AJAX.html(url,function (html) {
    //         layer.open({
    //             type:1,
    //             content:html,
    //             closeBtn:1,
    //             area:["600px"],
    //             title:"客户转移",
    //             btn:["转移"],
    //             yes:function (index,layero) {
    //                 EMP.changed();
    //             }
    //         })
    //     })
    // },
    //
    // changed:function () {
    //     var url = "/emp/changed"
    //     layer.confirm("确定转移该客户吗?", function () {
    //         AJAX.post(url,$("#changeForm").serialize(),function (result) {
    //             alert($("#changeForm").serialize());
    //             if (result.status == 200){
    //                 layer.closeAll();
    //                 EMP.list();
    //                 layer.alert("转移成功");
    //             }else {
    //                 layer.alert(result.message);
    //             }
    //         })
    //     })
    // }
}
