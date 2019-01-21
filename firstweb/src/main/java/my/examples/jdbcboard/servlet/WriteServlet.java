package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.FreeBoardDao;
import my.examples.jdbcboard.dao.FreeBoardDaoImpl;
import my.examples.jdbcboard.dto.FreeBoard;
import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.service.FreeBoardService;
import my.examples.jdbcboard.service.FreeBoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "WriteServlet", urlPatterns = "/write")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        User user = (User) req.getSession().getAttribute("logininfo");

        FreeBoardService freeBoardService = new FreeBoardServiceImpl();
        FreeBoard freeboard = new FreeBoard();
        freeboard.setUser_id(user.getUser_id());    //        board.setUserId(user.getId());
        freeboard.setUser_name(user.getUser_name());
        freeboard.setTitle(title);
        freeboard.setContent(content);
        freeBoardService.addFreeBoard(freeboard);

        resp.sendRedirect("/list");
    }
}
