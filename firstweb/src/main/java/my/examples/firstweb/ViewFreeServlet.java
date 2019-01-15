package my.examples.firstweb;

import my.examples.jdbcboard.exam.FreeBoardDao;
import my.examples.jdbcboard.exam.FreeBoardDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// read?id=5
@WebServlet(name = "ViewFreeServlet", urlPatterns = "/freeview")
public class ViewFreeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        long id = 0;
        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            // 오류 화면으로 redirect
            return;
        }
        FreeBoardDao freeBoardDao = new FreeBoardDaoImpl();
        FreeBoard freeBoard = freeBoardDao.getFreeBoard(id);
        if(freeBoard == null){
            // 오류 화면으로 redirect
            return;
        }

        req.setAttribute("freeboard", freeBoard);
        RequestDispatcher requestDistpatcher = req.getRequestDispatcher("/WEB-INF/views/freeview.jsp");
        requestDistpatcher.forward(req, resp);
    }
}
