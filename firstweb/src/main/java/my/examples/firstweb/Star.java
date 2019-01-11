package my.examples.firstweb;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Star", urlPatterns = "/star")
public class Star extends HttpServlet {
    public Star(){
        System.out.println("Star()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("   <head><title>Star</title></head>");
        out.println("   <body>");
        int height = Integer.parseInt(req.getParameter("height"));

        for(int i=1;i<height;i++){
            for(int j=1;j<=i;j++){
                out.print("*");
            }
            out.println("<br>");
        }

        out.println("   </body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("----- destroy -----");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("----- init -----");
    }
}
