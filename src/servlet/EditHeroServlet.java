package servlet;

import bean.Hero;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/22.
 */
public class EditHeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        Hero hero = new HeroDao().get(id);

        /*
        String htmlFormat = "<form action=\"/editHero?id=%d\" method=\"post\">\n" +
                "        名字：<input type=\"text\" name=\"name\" value=\"%s\"><br>\n" +
                "        血量：<input type=\"text\" name=\"hp\" value=\"%.2f\"><br>\n" +
                "        伤害：<input type=\"text\" name=\"damage\" value=\"%d\"><br>\n" +
                "        <input type=\"submit\" value=\"更新\">\n" +
                "    </form>";

        String backHtml = String.format(htmlFormat,hero.id,hero.name,hero.hp,hero.damage);

        resp.getWriter().println(backHtml);
         */
        //将上面的代码进行修改
        req.setAttribute("hero",hero);
        req.getRequestDispatcher("editHero.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        Hero hero = new Hero();
        hero.id = id;

        hero.name = req.getParameter("name");
        hero.hp = Float.parseFloat(req.getParameter("hp"));
        hero.damage = Integer.parseInt(req.getParameter("damage"));
        new HeroDao().update(hero);

        resp.sendRedirect("/listHero");
    }
}
