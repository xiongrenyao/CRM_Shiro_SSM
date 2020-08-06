package com.controller;

import com.pojo.Employee;
import com.service.CusService;
import com.service.EmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ComonController {
    @Resource
    private EmpService empService;

    @RequestMapping("main")
    public String main() {
        return "main";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String msg = null;
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            msg = "账号错误";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            msg = "密码错误";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "其他错误";
        }
        if (null != msg) {
            session.setAttribute("msg", msg);
            return "redirect:/index.jsp";
        }
        Employee employee = empService.findByLogin(username);
        session.setAttribute("LoginUser", employee);
        return "redirect:/main";
    }

    @RequestMapping("toRegiste")
    public String toRegiste() {
        return "emp/registe";
    }

    @RequestMapping("registe")
    public String registe(Employee employee, HttpSession session) {
        String md5Pass = new Md5Hash(employee.getPassword(), "skeye", 2).toString();
        System.out.println("md5:" + md5Pass);
        employee.setPassword(md5Pass);
        empService.addEmp(employee);
        String msg = "注册成功";
        session.setAttribute("msg", msg);
        return "redirect:/login";
    }

    @RequestMapping("/loginout")
    public void loginout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("LoginUser");
        if (employee != null) {
            session.removeAttribute("LoginUser");
            request.setAttribute("info", employee.getUsername() + " 已成功退出！");
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
