package com.wlw.emp.servlet.controller;

import com.wlw.emp.service.EmpService;
import com.wlw.emp.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveEmpController",value = "/manager/safe/remove-emp-controller")
public class RemoveEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));//获得id

        EmpService empService = new EmpServiceImpl();
        empService.removeEmp(id);//执行删除
        //跳转到ShowAllEmpController 进行重新显示
        response.sendRedirect(request.getContextPath()+"/manager/safe/show-all-emp-controller");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
