package my.examples.firstweb;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RedirectServlet", urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RedirectServlet - service()");
        resp.sendRedirect("/plus?a=50&b=100");

        // 크롬 개발자도구 -> netword -> redirect 상태코드 302 확인 -> ResponseHeader의 Location 확인.
        // 웹브라우저가 상태코드 302를 받으면 ResponseHeader에서 Location을 찾고 해당하는 경로로 다시 요청을 보낸다.

    }
}
