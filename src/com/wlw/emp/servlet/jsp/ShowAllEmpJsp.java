package com.wlw.emp.servlet.jsp;

import com.wlw.emp.entity.Emp;
import com.wlw.emp.entity.EmpManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllEmpJsp",value = "/manager/safe/show-all-emp-jsp")
public class ShowAllEmpJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmpManager empManager = (EmpManager) request.getSession().getAttribute("empManager");
        //获得ShowAllEmpController 转发过来的全部员工信息
        List<Emp> emps = (List<Emp>)request.getAttribute("emps");

        //响应
        PrintWriter writer = response.getWriter();
        if(emps != null){
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset='utf-8'>");
            writer.println("<title>显示所有员工</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>欢迎你："+ empManager.getUsername() +"</h1>");
            writer.println("<div><a href='"+ request.getContextPath() + "/manager/safe/add-emp-jsp" + "'>新增员工</a></div>");
            writer.println("<table border='1'>");
            writer.println("    <tr>");
            writer.println("        <td>编号</td>");
            writer.println("        <td>姓名</td>");
            writer.println("        <td>工资</td>");
            writer.println("        <td>年龄</td>");
            writer.println("        <td colspan='2'>操作</td>");
            writer.println("    </tr>");
            for (Emp emp : emps){
                writer.println("    <tr>");
                writer.println("        <td>"+emp.getId()+"</td>");
                writer.println("        <td>"+emp.getName()+"</td>");
                writer.println("        <td>"+emp.getSalary()+"</td>");
                writer.println("        <td>"+emp.getAge()+"</td>");
                writer.println("        <td> <a href='"+request.getContextPath()+"/manager/safe/remove-emp-controller?id="+emp.getId()+"'>删除</a> </td>");
                writer.println("        <td> <a href='"+request.getContextPath()+"/manager/safe/show-emp-controller?id="+emp.getId()+"'>修改</a> </td>");
                writer.println("    </tr>");
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");
        }else {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset='utf-8'>");
            writer.println("<title>显示所有员工</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>当前没有员工</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}