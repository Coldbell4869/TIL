package my.examplse.firstweb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BoardListServlet", urlPatterns = "/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("count", 100);
        List<Board> list = new ArrayList<>();
        list.add(new Board("kim", "title1", "content1"));
        list.add(new Board("lee", "title2", "content2"));
        list.add(new Board("hong","title3","content3"));
        req.setAttribute("list",list);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req,resp);

    }
}
