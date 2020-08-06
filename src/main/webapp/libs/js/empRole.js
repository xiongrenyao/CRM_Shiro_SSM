var EMPROLE = {
    edit: function (id) {
        var url = "/empRole/editRole?id=" + id;
        AJAX.html(url, function (html) {
            layer.open({
                type: 1,
                content: html,
                closeBtn: 1,
                area: ["600px"],
                titel: "角色修改",
                shade: "0.8",
                btn: ["提交"],
                yes: function () {
                    EMPROLE.update()
                }
            })
        })
    },
    update: function () {
        var url = "/empRole/updateRole";
        AJAX.post(url, $("#sysForm6").serialize(), function (result) {
            if (result.status == 200) {
                layer.closeAll();
                EMP.list();
                layer.alert("修改成功");
            } else {
                layer.alert(result.message);
            }
        })
    }
}