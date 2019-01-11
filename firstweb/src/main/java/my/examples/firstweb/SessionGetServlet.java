package my.examples.firstweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "SessionGetServlet", urlPatterns = "/sessionget")
public class SessionGetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // getSession(true); 이미 만들어진 것이 있으면 만들어진 것을 리턴하고,
        // 없으면 새로 만들어서 리턴.
        // getSession(false) : 이미 만들어져 있을 경우에만 리턴.
        HttpSession session = req.getSession(true);
        if(session.isNew()){
            out.println("방금 만들었다. <br>");
        }

        Enumeration<String> attributeNames
                = session.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            int value = (int)session.getAttribute(name);
            out.println(name + " , " + value + "<br>");
        }

        out.println("세션을 설정합니다.");
    }
}