package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2017/7/29.
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web应用初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web销毁");
    }
}
