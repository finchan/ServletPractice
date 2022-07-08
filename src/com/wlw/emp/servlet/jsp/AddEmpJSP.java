package com.wlw.emp.servlet.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="AddEmpJSP", value="/manager/safe/add-emp-jsp")
public class AddEmpJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset='utf-8'>");
        writer.println("<title>显示所有员工</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>新增员工</h1>");
        writer.println("    <form action='"+req.getContextPath()+"/manager/safe/add-emp-controller' method='post'>");
        writer.println("    姓名：<input type='text' name='name' value='' /><br/>");
        writer.println("    工资：<input type='text' name='salary' value='' /><br/>");
        writer.println("    年龄：<input type='text' name='age' value='' /><br/>");
        writer.println("    <input type='submit'  value='新增' /><br/>");
        writer.println("    </form>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
