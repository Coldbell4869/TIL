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
import java.util.List;

@WebServlet(name="ListFreeServlet", urlPatterns = "/freelist")
public class ListFreeServlet extends HttpServlet {
    private static final long SIZE = 3L; // 설정파일에서 읽어들이도록 수정한다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. page 값을 파라미터로 읽어들인다. 값이 없으면 기본값은 1페이지로 한다.
        String pageStr = req.getParameter("page");
        long page = 1L;
        try{
            page = Long.parseLong(pageStr);
        }catch(Exception igonre){}
        // 2. 1페이지란 0부터 시작하여 3건을 의미한다.
        long start = page * SIZE -SIZE;
        long limit = SIZE;
        // 3. DB에서 목록을 읽어들인다.
        FreeBoardDao freeBoardDao = new FreeBoardDaoImpl();
        List<FreeBoard> freeboards = freeBoardDao.getFreeBoards(start, limit);
        // 4. request에 3에서 구한 값을 setAttribute로 담아서 jsp에게 전달한다.
        req.setAttribute("freeboards", freeboards);
        // 5. jsp에서는 jstl과 el로 결과를 출력한다.

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/freeboard.jsp");
        requestDispatcher.forward(req, resp);
    }
}
