package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/29.
 */
public class IpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("随tomcat启动而启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //进行转换为httpServlet请求和响应
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //获得访问ip
        String ip = request.getRemoteAddr();
        String url = request.getRequestURL().toString();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String datef = simpleDateFormat.format(date);

        System.out.printf("%s %s 访问了%s%n",datef,ip,url);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
