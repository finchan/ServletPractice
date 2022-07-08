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
import java.util.List;

@WebServlet(name = "ShowAllEmpController",value = "/manager/safe/show-all-emp-controller")
public class ShowAllEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //权限验证，放在了过滤器里
        //业务逻辑，查询所有
        EmpService empService = new EmpServiceImpl();
        List<Emp> emps = empService.showAllEmp();

        //request域保存，转发跳转到ShowAllEmpJsp
        request.setAttribute("emps",emps);
        request.getRequestDispatcher("/manager/safe/show-all-emp-jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}