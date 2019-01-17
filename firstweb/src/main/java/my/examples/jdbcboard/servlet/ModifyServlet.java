package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.FreeBoardDao;
import my.examples.jdbcboard.dao.FreeBoardDaoImpl;
import my.examples.jdbcboard.dto.FreeBoard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// update?id=5
@WebServlet(name = "ModifyServlet", urlPatterns = "/modify")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. id 값을 파라미터로 읽어들인다. 값이 없으면 기본값은 0으로 한다.
        String idStr = req.getParameter("id");
        Long id = 0L;
        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            // 오류 화면으로 redirect
            return;
        }
        // 3. DB에서 해당 글을 읽어들인다.
        FreeBoardDao freeBoardDao = new FreeBoardDaoImpl();
        FreeBoard freeBoard = freeBoardDao.getFreeBoard(id);
        if(freeBoard == null){
            // 오류 화면으로 redirect
            return;
        }


        // 4. request에 3에서 구한 값을 setAttribute로 담아서 jsp에게 전달한다.
        req.setAttribute("id", id);
        req.setAttribute("freeboard", freeBoard);

        // 5. jsp에서는 jstl과 el로 결과를 출력한다.
        RequestDispatcher requestDistpatcher = req.getRequestDispatcher("/WEB-INF/views/modify.jsp");
        requestDistpatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long id = 0L;
        String title = null;
        String content = null;
        String name = null;
        try {
            name = req.getParameter("name");
            title = req.getParameter("title");
            content = req.getParameter("content");
            String idStr = req.getParameter("id");

            id = Long.parseLong(idStr);

        } catch (Exception ex) {
        }
        FreeBoardDao boardDao = new FreeBoardDaoImpl();
//        boardDao.updateBoard(name, title, content, id);
        resp.sendRedirect("list");
    }
}
