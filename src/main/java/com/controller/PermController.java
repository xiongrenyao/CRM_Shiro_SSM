package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Perm;
import com.service.PermService;
import com.utils.Page;
import com.utils.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("perm")
public class PermController {
    @Resource
    private PermService permService;


    //    @RequestMapping("showAll")
//    @RequiresPermissions("/perm/showAll")
//    public String show(HttpServletRequest request){
//        List<Perm> list = permService.findAllPerm();
//        request.setAttribute("list",list);
//        return "perm/showAll";
//    }
    @RequestMapping("showAll")
    @RequiresPermissions("/perm/showAll")
    public String showAll() {
        return "perm/showAll";
    }

    @RequestMapping("showAllByPage")
    @RequiresPermissions("/perm/showAll")
    @ResponseBody
    public String showAllByPage(Page page, HttpServletResponse response) {
        page.setStartPage((page.getCurrentPage() - 1) * page.getPageSize());    //起始页
        page.setCount(permService.count());
        List<Perm> permList = permService.findAllPermByPage(page);
        if (page.getCount() % page.getPageSize() > 0) {
            page.setMaxPage(page.getCount() / page.getPageSize() + 1);
        } else {
            page.setMaxPage(page.getCount() / page.getPageSize());
        }
        Object[] objs = {permList, page.getMaxPage()};//回传数据
        response.setContentType("text/html;charset=utf-8");
        return JSONArray.toJSONString(objs);
    }

    @RequestMapping("add")
    @RequiresPermissions("/perm/add")
    public String add(HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        return "perm/addPerm";
    }

    @RequestMapping("save")
    @RequiresPermissions("/perm/save")
    @ResponseBody
    public Result doAdd(Perm perm) {
        permService.addPerm(perm);
        return Result.ok();
    }

    @RequestMapping("edit")
    @RequiresPermissions("/perm/edit")
    public String edit(int permId, HttpServletRequest request, HttpServletResponse response) {
        Perm perm = permService.findById(permId);
        response.setContentType("text/html;charset=utf-8");
        request.setAttribute("perm", perm);
        return "perm/editPerm";
    }

    @RequestMapping("update")
    @RequiresPermissions("/perm/update")
    @ResponseBody
    public Result doEdit(Perm perm) {
        permService.modifyPerm(perm);
        return Result.ok();
    }

    @RequestMapping("delete")
    @RequiresPermissions("/perm/delete")
    @ResponseBody
    public Result remove(int permId) {
        permService.removePerm(permId);
        return Result.ok();
    }
}
