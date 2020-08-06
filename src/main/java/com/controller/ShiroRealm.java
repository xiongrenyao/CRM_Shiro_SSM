package com.controller;

import com.pojo.*;
import com.service.*;
import com.service.impl.EmpRoleServiceImpl;
import com.service.impl.EmpServiceImpl;
import com.service.impl.RolePermServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ShiroRealm extends AuthorizingRealm {

    private EmpService empService;
    private EmpRoleService empRoleService;
    private RolePermService rolePermService;
    private RoleService roleService;
    private PermService permService;

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    public void setEmpRoleService(EmpRoleService empRoleService) {
        this.empRoleService = empRoleService;
    }

    public void setRolePermService(RolePermService rolePermService) {
        this.rolePermService = rolePermService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public void setPermService(PermService permService) {
        this.permService = permService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        Employee emp = (Employee) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        EmpRole empRole = empRoleService.findByEmpId(emp.getEmpId());
        Role role = roleService.findById(empRole.getRoleId());
        List<String> permList = permService.findAllPemrByRoleId(role.getRoleId());
        info.addRole(role.getRoleId() + "");
        info.addStringPermissions(permList);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("授权中。。。。。");
        String username = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());
        String salt = "skeye";
        String md5Password = new Md5Hash(password, salt, 2).toString();
        System.out.println(md5Password);
        System.out.println("认证密码为:" + password);
        Employee employee = empService.findByLogin(username);
        if (employee == null) {
            throw new UnknownAccountException();
        }
        if (employee != null && !md5Password.equals(employee.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        //System.err.println("认证后......."+employee);
        return new SimpleAuthenticationInfo(employee, md5Password, ByteSource.Util.bytes(salt), getName());
    }
}
