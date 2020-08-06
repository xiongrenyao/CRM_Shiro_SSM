var PERM = {
    list: function () {
        var url = "/perm/showAll";
        AJAX.html(url, function (html) {
            $("#right").html(html);
        })
    },

    add: function () {
        var url = "/perm/add";
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                shade: "0.8",
                title: "权限添加",
                btn: ['保存'],
                yes: function (index, layero) {
                    PERM.save();
                }
            });
        })
    },

    save: function () {
        var url = "/perm/save";
        AJAX.post(url, $("#sysForm5").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();//关闭添加框
                PERM.list();
                layer.alert("添加成功");
            } else {
                layer.alert(result.message);
            }
        });

    },

    edit: function (id) {
        var url = "/perm/edit?permId=" + id;
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                title: "权限更新",
                btn: ['更新'],
                yes: function (index, layero) {
                    PERM.update();
                }
            });
        })
    },

    update: function () {
        var url = "/perm/update";
        AJAX.post(url, $("#sysForm5").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();//关闭添加框
                PERM.list();
                layer.alert("修改成功");
            } else {
                layer.alert(result.message);
            }
        });

    },

    remove: function (id) {
        var url = "/perm/delete";
        layer.confirm("确认删除此记录？", function () {
            AJAX.post(url, {permId: id}, function (result) {
                if (result.status == 200) {
                    layer.closeAll();
                    PERM.list();
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
