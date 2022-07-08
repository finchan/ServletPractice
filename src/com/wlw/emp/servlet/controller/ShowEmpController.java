package com.wlw.emp.servlet.controller;

import com.wlw.emp.entity.Emp;
import com.wlw.emp.service.EmpService;
import com.wlw.emp.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowEmpController",value = "/manager/safe/show-emp-controller")
public class ShowEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));//收参

        EmpService empService = new EmpServiceImpl();
        Emp emp = empService.showEmp(id);//执行单个查询

        request.setAttribute("emp",emp);//将要修改的员工信息 存入request域中，在修改页面做展示
        request.getRequestDispatcher("/manager/safe/show-update-emp-infojsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}