<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="sysForm3" class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-4 control-label">客户单位</label>
        <div class="col-sm-6">
            <input class="form-control required" name="cusName" id="cusName">
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">地址</label>
        <div class="col-sm-6">
            <input class="form-control required" name="address" id="address">
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">联系人</label>
        <div class="col-sm-6">
            <input class="form-control required" name="contact" id="contact">
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">电话</label>
        <div class="col-sm-6">
            <input class="form-control required" name="tel" id="tel">
        </div>
        <div class="col-sm-4"></div>
    </div>

    <div class="form-group">
        <label class="col-sm-4 control-label">邮箱</label>
        <div class="col-sm-6">
            <input class="form-control required email" name="email" id="email">
        </div>
        <div class="col-sm-4"></div>
    </div>
</form>
