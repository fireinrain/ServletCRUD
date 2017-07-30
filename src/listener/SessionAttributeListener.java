package listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by Administrator on 2017/7/30.
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session 增加属性");
        System.out.println("属性是："+se.getName());
        System.out.println("值是："+se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("属性移除");

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session属性替换");

    }
}
