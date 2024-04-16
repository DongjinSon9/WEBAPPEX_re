package org.zerock.w1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calcController", urlPatterns = "/calc/MakeResult")
public class MakeResult extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        System.out.printf(" num1: %s", num1);
        System.out.printf(" num2: %s", num2);

//        서블릿이나 컨트롤의 주소를 입력하면 맞는 내용이 실행
        resp.sendRedirect("/index");
    }
}
