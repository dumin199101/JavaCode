package com.goosuu.code04;

/**
 *
 * Cookie:
 *   创建Cookie
 *     new Cookie(String key,String value)
 *     getName()
 *     getValue()
 *   设置Cookie
 *     response.addCookie(Cookie cookie)
 *   获取Cookie
 *     Cookie[] request.getCookies()
 *
 *   Cookie存储时间：
 *      默认情况下，存储在内存中，随浏览器关闭而消失
 *      持久化存储：
 *          setMaxAge(int seconds)
 *          正数：存储cookie数据到硬盘文件中
 *          负数：默认值,存储在内存中
 *          零：删除cookie
 *
 *   Cookie共享范围：
 *      默认共享范围为当前虚拟目录
 *      SetPath()
 *      setDomain()
 *
 *   Session:
 *     获取HttpSession:
 *       request.getSession()
 *     Session域对象,会话范围内数据有效
 *        getAttribute()
 *        setAttribute()
 *        removeAttribute()
 *        getId():获取SessionID
 *
 *     Session数据保存：
 *       work目录中
 *       Session钝化：服务器关闭时，将Session对象保存到硬盘文件中
 *       Session活化：服务器恢复时，将Session文件转化为Session对象
 *
 *     Session销毁：
 *       invalidate()
 *       默认失效时间：30分钟,web.xml中可配置
 *       <session-config>
 *         <session-timeout>30</session-timeout>
 *       </session-config>
 *
 */
public class CookieDemo {

}
