package com.goosuu.code06;
/**
 *  Filter过滤器：
 *    Filter生命周期：
 *      init():服务器启动后，创建Filter对象，调用init方法，只执行一次
 *      doFilter():每一次请求被拦截时被执行，执行多次
 *      destroy():服务器正常关闭时，Fliter对象销毁时被执行，只执行一次
 *    配置：
 *      1.注解：@WebFilter
 *      2.web.xml配置：
     *    <filter>
     *       <filter-name>FilterDemo</filter-name>
     *       <filter-class>com.goosuu.code06.FilterDemo</filter-class>
     *    </filter>
     *
     *    <filter-mapping>
     *       <filter-name>FilterDemo</filter-name>
     *       <url-pattern>/*</url-pattern>
     *    </filter-mapping>
 *
 *     拦截路径配置：
 *        拦截具体路径：/index.jsp
 *        拦截目录：/user/*
 *        后缀名拦截：*.jsp
 *        拦截所有资源：/*
 *
 *     拦截方式配置：
 *        注解：
 *          @WebFilter()
 *          设置dispatcherTypes属性
 *          1.REQUEST:默认,浏览器直接请求
 *          2.FORWARD:转发访问资源
 *          3.ERROR
 *          4.INCLUDE
 *          5.ASYNC
 *        web.xml方式：
 *           <filter-mapping>
         *       <filter-name>FilterDemo</filter-name>
         *       <url-pattern>/index.jsp</url-pattern>
         *       <dispatcher>REQUEST</dispatcher>
         *    </filter-mapping>
 *
 *    过滤器链：
 *       过滤器链执行流程：
 *          1. 过滤器1
 * 			2. 过滤器2
 * 			3. 资源执行
 * 			4. 过滤器2
 * 			5. 过滤器1
 * 		 过滤器链执行先后顺序：
 * 		    注解方式：按照类名字符串比较规则
 * 		    web.xml方式：谁定义在前边谁先执行
 *
 *    Listener监听器(了解)：
 *        1.定义一个类实现ServletContextListener接口
 *        2.复写方法
 *           contextInitialized(ServletContextEvent sce):服务器启动后被调用
 *           contextDestroyed(ServletContextEvent sce):服务器关闭后被调用
 *        3.配置
 *          注解：@WebListener
 *          web.xml方式
 *           <listener>
 *             <listener-class>com.goosuu.code06.ListenerDemo</listener-class>
 *           </listener>
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo implements Filter {
    public void destroy() {
        System.out.println("Filter destroy...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Hello Filter");
        chain.doFilter(req, resp);
        System.out.println("World Filter");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter init...");
    }

}
