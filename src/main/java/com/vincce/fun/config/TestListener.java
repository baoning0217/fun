package com.vincce.fun.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created By Baoning On 2019-01-17
 *
 * 根据监听事件，把监听器分为3类
 * (1)监听对象创建与销毁，ServletContextListener
 * (2)监听对象域中属性的增加与删除，HttpSessionListener和ServletRequestListener
 * (3)监听绑定到Session上的某个对象的状态，
 *              ServletContextAttributeListener、
 *              HttpSessionAttributeListener、
 *              ServletRequestListener
 *
 */
@WebListener
public class TestListener implements ServletContextListener {

    /**
     * 当Servlet容器启动Web应用时调用该方法，在调用该方法之后，容器再对Filter初始化，
     * 并且对那些在Web应用启动时就需要被初始化的Servlet进行初始化。
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("调用TestListener............");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
