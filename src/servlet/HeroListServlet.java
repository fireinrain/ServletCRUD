package servlet;


import bean.Hero;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
public class HeroListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html;charset=UTF-8");

        //判断用户是否登录
        String name = (String)req.getSession().getAttribute("userName");
        if (null==name){
            resp.sendRedirect("/login.html");
            return;
        }

        int start = 0;
        int count = 5;
        try{
            start = Integer.parseInt(req.getParameter("start"));
        }catch (NumberFormatException e){

        }

        //向后翻页
        int next = start+count;
        //向前翻页
        int pre = start-count;

        //尾页计算
        int total = new HeroDao().getTotal();
        int last;
        if (0==total%count){
            last = total-count;
        }else {
            last = total-total%count;
        }

        //翻页的边界处理
        pre = pre>0?0:pre;
        next = next>last?last:next;
        List<Hero> heroes = new HeroDao().list(start,count);
        //System.out.println(Arrays.asList(heroes));


        /*
        修改为mvc模式
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<table align=\"center\" border=\"1\" cellspacing=\"0\" >\r\n");
        stringBuffer.append("<tr>\n" +
                "      <td>编号(id)</td>\n" +
                "      <td>名称(name)</td>\n" +
                "      <td>血量(hp)</td>\n" +
                "      <td>伤害(damage)</td>" +
                "       <td>编辑(edit)</td>" +
                "       <td>删除(delete)</td></tr>\r\n");

        String sbFormat = "<tr>\n" +
                "      <td>%d</td>\n" +
                "      <td>%s</td>\n" +
                "      <td>%.2f</td>\n" +
                "      <td>%d</td>" +
                "       <td><a href=\"/editHero?id=%d\">修改</a></td>"+
                "       <td><a href=\"/deleteHero?id=%d\">删除</a></td></tr>\r\n";

        for (Hero h:heroes
             ) {
            String string = String.format(sbFormat,h.getId(),h.getName(),h.getHp(),h.getDamage(),h.getId(),h.getId());
            System.out.println(string);
            stringBuffer.append(string);
        }

        stringBuffer.append("</table>");
        resp.getWriter().write(stringBuffer.toString());
         */

        req.setAttribute("heroes",heroes);
        req.setAttribute("next",next);
        req.setAttribute("pre",pre);
        req.setAttribute("last",last);
        String ip = req.getRemoteAddr();
        req.setAttribute("ip",ip);

        req.getRequestDispatcher("listHero.jsp").forward(req,resp);


    }
}
