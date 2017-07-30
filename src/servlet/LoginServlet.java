package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/29.
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if ("admin".equals(name)&&"123".equals(password)){
            req.getSession().setAttribute("userName",name);
            resp.sendRedirect("/listHero");
        }else {
            resp.sendRedirect("/login.html");
        }
    }
}
