var ROLEPERM = {

    show: function () {
        var url = "/rolePerm/showRolePerm";
        AJAX.html(url, function (html) {
            $("#right").html(html)
        })
    },

    clickRole: function (id) {
        document.getElementById("roleId").setAttribute("value", id);
        // ROLEPERM.show();
        var url = "/rolePerm/showPerms";
        AJAX.post(url, {roleId: id}, function (result) {
            alert(result);
            // $("input:checkbox").attr("checked", false);
            var inputs = $("input:checkbox");
            inputs.each(function () {
                // alert("chekbox："+$(this).val())
                var n = 0;
                for (var i = 0; i < result.length; i++) {
                    if ($(this).val() == result[i]) {
                        // alert("勾上"+$(this).val());
                        $(this).prop("checked", true);
                        n = 0;
                        break;
                    }
                    n = 1;
                }
                if (n == 1) {
                    // alert("不勾"+$(this).val());
                    $(this).prop("checked", false);
                }


            })

            // for (var i=0;i<result.length;i++){
            //     $("input:checkbox[value='"+result[i]+"']").attr("checked", true);
            // }
        });
    },

    checkBox: function (id) {
        var rid = $("#roleId").val();

        var permBox = $("input:checkbox[value='" + id + "']").prop("checked");
        if (permBox) {
            var url = "/rolePerm/addRolePerm";
            AJAX.post(url, {roleId: rid, permId: id}, function (result) {
                alert(result.message);
            });
        } else {
            var url = "/rolePerm/removeRolePerm";
            AJAX.post(url, {roleId: rid, permId: id}, function (result) {
                alert(result.message);
            });
        }
    }
}

