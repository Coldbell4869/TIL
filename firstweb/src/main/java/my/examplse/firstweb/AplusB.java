package my.examplse.firstweb;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AplusB", urlPatterns = "/aplusb")
public class AplusB extends HttpServlet {
    public AplusB(){
        System.out.println("AplusB()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));

        out.println("<html>");
        out.println("   <head><title>A+B=?</title></head>");
        out.println("   <body>");

            out.print("<h2>a="+a+"</h2>");
            out.print("<h2>b="+b+"</h2>");
            out.print("<h1>a+b="+(a+b)+"</h1>");

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
