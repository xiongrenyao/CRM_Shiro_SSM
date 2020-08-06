<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="sysForm2" class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-4 control-label">公司名称</label>
        <div class="col-sm-6">
            <select class="form-control" name="cusId">
                <option value="0">请选择</option>
                <c:forEach items="${ecList}" var="ec">
                    <option value="${ec.cus.cusId}">${ec.cus.cusName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group" hidden="hidden">
        <label class="col-sm-4 control-label">联系人</label>
        <div class="col-sm-6">
            <input class="form-control" type="text" name="contact"/>
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">员工名</label>
        <div class="col-sm-6">
            <input name="empId" value="${emp.empId}" hidden="hidden"/>
            <input class="form-control" type="text" name="name" value="${emp.name}" readonly="readonly"/>
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">拜访内容</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" name="content"></textarea>
        </div>
        <div class="col-sm-4"></div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">时间</label>
        <div class="col-sm-6">
            <input class="Wdate" name="date" onclick="WdatePicker()"/>
        </div>
        <div class="col-sm-4"></div>
    </div>
</form>
