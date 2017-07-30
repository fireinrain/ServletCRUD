package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by Administrator on 2017/7/30.
 */
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener{
    //request属性监听
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("add attribute to request");
        System.out.println("the attribute name:"+srae.getName()+"----value: "+srae.getValue());

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("remove attribute from the request");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("the request attribute was replaced");
    }



    //request监听
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("destroy a request");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("create a new request");
    }
}
