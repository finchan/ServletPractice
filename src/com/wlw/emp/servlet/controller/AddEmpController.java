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

@WebServlet(name="AddEmpController", value="/manager/safe/add-emp-controller")
public class AddEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 收参
        String name = req.getParameter("name");
        Double salary = Double.valueOf(req.getParameter("salary"));
        int age = Integer.valueOf(req.getParameter("age"));
        Emp emp = new Emp(name, salary, age);
        EmpService empService = new EmpServiceImpl();
        empService.addEmp(emp);
        resp.sendRedirect(req.getContextPath()+"/manager/safe/show-all-emp-controller");
    }
}
