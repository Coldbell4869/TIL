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

@WebServlet(name = "FreeListServlet", urlPatterns = "/free/list")
public class FreeListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FreeDTO> freelist = new ArrayList<>();
        freelist.add(new FreeDTO(5, "둘리", "호이가 계속되면 둘리인줄 알아요", 261));
        freelist.add(new FreeDTO(4, "도우너", "도우너 글 제목", 153));
        freelist.add(new FreeDTO(3, "또치","또치또치", 93));
        freelist.add(new FreeDTO(2, "고길동","고길동의 글.",112));
        freelist.add(new FreeDTO(1, "마이콜","마이콜유어콜시시콜콜",92));
        req.setAttribute("freelist",freelist);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/freelist.jsp");
        requestDispatcher.forward(req,resp);

    }
}
