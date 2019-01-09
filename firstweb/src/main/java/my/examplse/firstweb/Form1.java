package my.examplse.firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Form1", urlPatterns = "/form1")
public class Form1 extends HttpServlet {
    public Form1(){
        System.out.println("Form1()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String[] checkbox = req.getParameterValues("checkbox");
        String radio = req.getParameter("radio");
        String password = req.getParameter("password");
        String title = req.getParameter("title");
        String contents = req.getParameter("contents");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("   <head><title>form1 제출결과</title></head>");
        out.println("   <body>");

        out.println("작성자 : "+ name + "<br>");

        out.print("체크박스 : ");
        for(int i = 0 ; i < checkbox.length ; i++){
            out.print(checkbox[i]);
        }out.print("<br>");
        out.print("라디오버튼 : "+ radio + "<br>");
        out.print("비밀번호 : "+ password + "<br>");
        out.print("제목 : "+ title + "<br>");
        out.print("내용 : "+ contents + "<br>");

        out.println("   </body>");
        out.println("</html>");

        //자원 해제
        out.close();
    }

}