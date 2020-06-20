package com.goosuu.code05;

/*
 *    JSP:
 *      本质：Servlet
 *      可以在JSP中嵌入Java代码,编译后存在work目录中
 *      <% java代码 % >：在Servlet的Service方法中的内容
 *      <%! java代码 %>：在Servlet成员位置定义的内容,相当于JSP声明
 *      <%= java变量 %>：输出变量
 *
 *      指令：
 *        格式：<%@指令名称 属性名=属性值...%>
 *        1.page:配置JSP页面
 *             contentType
 *             pageEncoding
 *             language
 *             buffer:默认8kb,out缓冲区有关
 *             import:导包
 *             errorPage:发生异常后,跳转错误页面
 *             isErrorPage:标识当前页面是否是错误页面,可使用exception对象
 *        2.include：页面包含
 *           <%@include file="top.jsp" %>
 *        3.taglib：导入资源
 *          <%@taglib prefix="c" uri="" %>
 *
 *      9大内置对象：
 *         pageContext   PageContext
 *         request       HttpServletRequest
 *         session       HttpSession
 *         application   ServletContext
 *         response      HttpServletResponse
 *         page          Object,当前Servlet对象
 *         out           JspWriter
 *         config        ServletConfig
 *         exception     Throwable
 *
 *     域对象：
 *        pageContext,request,session,application
 *        pageContext:当前页面共享数据
 *        request:一次请求共享数据
 *        session:一次会话共享数据
 *        application:所有用户共享数据
 *
 *     注意：
 *         pageContext可以去取其它八个内置对象
 *         response缓冲区优先于out缓冲区
 *
 *      注释：
 *        <%--注释内容--%>
 *
 *   MVC模式：
 *      Controller---->Servlet【获取用户输入,调用模型,将数据交给视图】
 *      Model---->JavaBean【操作数据库,业务逻辑】
 *      View----->JSP【展示数据】
 */
public class JSPDemo {
}
