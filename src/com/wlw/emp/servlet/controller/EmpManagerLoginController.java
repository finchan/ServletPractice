package com.wlw.emp.servlet.controller;

import com.wlw.emp.entity.EmpManager;
import com.wlw.emp.service.EmpManagerService;
import com.wlw.emp.service.impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="EmpManagerLoginController", value="/manager/emp-manager-login-controller")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 接收参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputVcode = req.getParameter("inputVcode");
        //2. 校验验证码
        String codes = (String) req.getSession().getAttribute("codes");
        if(inputVcode != null && inputVcode.equalsIgnoreCase(codes)){
            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EmpManager empManager = empManagerService.login(username, password);
            if(empManager != null) {
                req.getSession().setAttribute("empManager", empManager);
                resp.sendRedirect(req.getContextPath()+"/manager/safe/show-all-emp-controller");
            } else {
                resp.sendRedirect(req.getContextPath() + "/login.html");
            }
        } else { //验证码错误
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }
}
