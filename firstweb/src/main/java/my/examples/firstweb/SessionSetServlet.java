package my.examples.firstweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionSetServlet", urlPatterns = "/sessionset")
public class SessionSetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        if(session.isNew()){
            out.println("방금 만들었다. <br>");
        }

        int rand = (int)(Math.random() * 1000);
        session.setAttribute("name" + rand, rand);

        out.println("세션을 설정합니다.");
    }
}
