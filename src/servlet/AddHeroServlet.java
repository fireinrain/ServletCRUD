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
public class AddHeroServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("UTF-8");

        Hero hero = new Hero();

        hero.setName(req.getParameter("name"));
        hero.setHp(Float.parseFloat(req.getParameter("hp")));
        hero.setDamage(Integer.parseInt(req.getParameter("damage")));

        new HeroDao().add(hero);
        resp.sendRedirect("/listHero");//进行客户端跳转
    }
}
