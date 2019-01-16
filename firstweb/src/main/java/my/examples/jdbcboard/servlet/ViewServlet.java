package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.FreeBoardDao;
import my.examples.jdbcboard.dao.FreeBoardDaoImpl;
import my.examples.jdbcboard.dto.FreeBoard;
import my.examples.jdbcboard.service.FreeBoardService;
import my.examples.jdbcboard.service.FreeBoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// read?id=5
@WebServlet(name = "ViewServlet", urlPatterns = "/view")
public class ViewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long id = 0L;
        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            // 오류 화면으로 redirect
            return;
        }

        FreeBoardService freeBoardService = new FreeBoardServiceImpl();
        FreeBoard freeBoard = freeBoardService.getFreeBoard(id);

//        freeBoardDao.updateReadCount(id);

        req.setAttribute("freeboard", freeBoard);
        RequestDispatcher requestDistpatcher = req.getRequestDispatcher("/WEB-INF/views/view.jsp");
        requestDistpatcher.forward(req, resp);
    }
}
