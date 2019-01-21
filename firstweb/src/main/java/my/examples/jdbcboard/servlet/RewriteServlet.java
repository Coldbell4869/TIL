package my.examples.jdbcboard.servlet;

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
import java.io.IOException;


@WebServlet(name = "RewriteServlet", urlPatterns = "/rewrite")
public class RewriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = 0;
        String idStr = req.getParameter("id");

        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            ex.printStackTrace();
            return;
        }

        FreeBoardService freeBoardService = new FreeBoardServiceImpl();
        FreeBoard freeboard = freeBoardService.getFreeBoard(id);

        String content = freeboard.getContent();
        content = content.replaceAll("\n", "> ");
        System.out.println(content);
        freeboard.setContent(content);

        req.setAttribute("freeboard", freeboard);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/rewrite.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = 0;
        String idStr = req.getParameter("id");

        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            ex.printStackTrace();
            return;
        }
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        User user = (User) req.getSession().getAttribute("logininfo");
        FreeBoardService freeBoardService = new FreeBoardServiceImpl();
        FreeBoard freeboard = new FreeBoard();
        freeboard.setId(id);
        freeboard.setUser_id(user.getUser_id());
        freeboard.setUser_name(user.getUser_name());
        freeboard.setTitle(title);
        freeboard.setContent(content);
        freeBoardService.addReFreeBoard(freeboard);
        resp.sendRedirect("/list");
    }
}
