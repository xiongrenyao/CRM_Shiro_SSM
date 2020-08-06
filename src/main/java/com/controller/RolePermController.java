package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Perm;
import com.pojo.Role;
import com.pojo.RolePerm;
import com.service.PermService;
import com.service.RolePermService;
import com.service.RoleService;
import com.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("rolePerm")
public class RolePermController {

    @Resource
    private RolePermService rolePermService;
    @Resource
    private PermService permService;
    @Resource
    private RoleService roleService;


    @RequestMapping("showRolePerm")
    public String show(HttpServletRequest request) {
        List<Role> roleList = roleService.findAllRole();
        List<Perm> permList = permService.findAllPerm();
        request.setAttribute("roleList", roleList);
        request.setAttribute("permList", permList);
        return "rolePerm/rolePermList";
    }

    @RequestMapping("showPerms")
    @ResponseBody
    public String showPerms(Integer roleId, HttpServletResponse response) {
        List<String> permIds = rolePermService.findPermByRoleId(roleId);
        response.setCharacterEncoding("utf-8");
        JSONObject.toJSONString(permIds);
        return JSONObject.toJSONString(permIds);
    }

    @RequestMapping("addRolePerm")
    @ResponseBody
    public Result addRolePerm(RolePerm rolePerm) {
        System.err.println("sadsa" + rolePerm + "================");
        int i = rolePermService.addRolePerm(rolePerm);
        if (i > 0) {
            return Result.ok();
        } else {
            return Result.error("添加失败");
        }
    }

    @RequestMapping("removeRolePerm")
    @ResponseBody
    public Result removeRolePerm(RolePerm rolePerm) {
        int i = rolePermService.removeRolePerm(rolePerm);
        if (i > 0) {
            return Result.ok();
        } else {
            return Result.error("删除失败");
        }
    }
}
