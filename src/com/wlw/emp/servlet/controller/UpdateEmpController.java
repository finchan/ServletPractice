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

@WebServlet(name = "UpdateEmpController",value = "/manager/safe/update-emp-controller")
public class UpdateEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //收参
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Double salary = Double.valueOf(request.getParameter("salary"));
        Integer age = Integer.valueOf(request.getParameter("age"));

        Emp emp = new Emp(id,name,salary,age);
        EmpService empService = new EmpServiceImpl();
        empService.modify(emp);//执行修改

        //修改后，跳转到ShowAllEmpController 进行重新展示
        response.sendRedirect(request.getContextPath()+"/manager/safe/show-all-emp-controller");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}