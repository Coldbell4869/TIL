package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.service.UserService;
import my.examples.jdbcboard.service.UserServiceImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String user_email = req.getParameter("user_email");
        String user_passwd = req.getParameter("user_passwd");

        UserService userService = UserServiceImpl.getInstance();
        User user = userService.getUserByEmail(user_email);
        if(user != null && user.getUser_passwd() != null){
            PasswordEncoder passwordEncoder =
                    PasswordEncoderFactories.createDelegatingPasswordEncoder();
            boolean matches = passwordEncoder.matches(user_passwd, user.getUser_passwd());
            if(matches){
                // 로그인정보를 세션에 저장.
                HttpSession session = req.getSession();
                session.setAttribute("logininfo", user); // 회원정보를 세션에 전달한다
                System.out.println("암호가 맞아요.");
            }else{
                // 암호가 틀렸어요.
                System.out.println("암호가 틀렸어요.");
            }
        }
        // 로그인 성공했다면
        resp.sendRedirect("/list");
    }
}