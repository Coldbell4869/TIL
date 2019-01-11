package my.examples.firstweb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FreeReadServlet", urlPatterns = "/free/read")
public class FreeReadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<FreeDTO> freeread = new ArrayList<>();
        freeread.add(new FreeDTO("5", "둘리", "호이가 계속되면 둘리인줄 알아요","요리보고 조리봐도 알수없는 둘리둘리", 261));
        freeread.add(new FreeDTO("4", "도우너", "도우너 글 제목","요리보고 조리봐도 알수없는 둘리둘리", 153));
        freeread.add(new FreeDTO("3", "또치","또치또치","요리보고 조리봐도 알수없는 둘리둘리", 93));
        freeread.add(new FreeDTO("2", "고길동","고길동의 글.","요리보고 조리봐도 알수없는 둘리둘리",112));
        freeread.add(new FreeDTO("1", "마이콜","마이콜유어콜시시콜콜","요리보고 조리봐도 알수없는 둘리둘리",92));


        String id = req.getParameter("id");
        FreeDTO view = new FreeDTO();

        for(int i=0;i<freeread.size();i++){
            if(freeread.get(i).getId() == id){

               view=freeread.get(i);
               req.setAttribute("freeview",view);
            }
        }



        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/freeread.jsp" +
                "");
        requestDispatcher.forward(req,resp);

    }
}
