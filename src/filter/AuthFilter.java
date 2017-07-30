package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/29.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String uri = request.getRequestURI();
        System.out.println("当前uri："+uri);

        //对于静态资源放行
        //如果访问的资源是以css或者js结尾的，那么就不需要判断是否登录
        if (uri.endsWith(".css") || uri.endsWith(".js")) {
            filterChain.doFilter(request, response);    //进入下一个过滤器
            return;
        }

        if (uri.endsWith("login.html")||uri.endsWith("login")){
            filterChain.doFilter(request,response);
            return;
        }
        //放行在线人数统计
        if (uri.equals("/checkOnlineNumber.jsp")){
            filterChain.doFilter(request,response);
            return;
        }

        String userName = (String)request.getSession().getAttribute("userName");
        if (null==userName){
            response.sendRedirect("login.html");
            return;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
