package com.wlw.emp.servlet.jsp;

import com.wlw.emp.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowUpdateEmpController",value = "/manager/safe/show-update-emp-infojsp")
public class ShowUpdateEmpInfoJSP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要修改的员工对象
        Emp emp = (Emp) request.getAttribute("emp");
        //展示
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("    <meta charset='utf-8'>");
        writer.println("    <title>修改员工信息页面</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("    <form action='"+request.getContextPath()+"/manager/safe/update-emp-controller' method='post'>");
        writer.println("    编号：<input type='text' name='id' value='"+emp.getId()+"' readonly/><br/>");
        writer.println("    姓名：<input type='text' name='name' value='"+emp.getName()+"' /><br/>");
        writer.println("    工资：<input type='text' name='salary' value='"+emp.getSalary()+"' /><br/>");
        writer.println("    年龄：<input type='text' name='age' value='"+emp.getAge()+"' /><br/>");
        writer.println("    <input type='submit'  value='修改' /><br/>");
        writer.println("    </form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}