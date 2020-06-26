package com.goosuu.code09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  动态代理：
 *     代理对象与真实对象实现相同接口
 *     创建代理对象
 *     代理对象调用方法
 *     增强方法
 *
 *     Proxy类
 *       static Object newProxyInstance(ClassLoader loader,Class[] interfaces,InvocationHandler h)
 *       参数：
 *         classLoader:真实对象类加载器
 *         interfaces:真实对象实现的接口
 *         InvocationHandler:处理器
 *      动态代理的作用：
 *         方法增强：
 *            1.参数增强
 *            2.返回值增强
 *            3.方法体增强
 *
 *
 */
public class SellComputerTest {
    public static void main(String[] args) {
        LenovoComputer lenovoComputer = new LenovoComputer();
        String sell = lenovoComputer.sell(8000.00);
        System.out.println(sell);
        lenovoComputer.show();
        System.out.println("-----------------------");
        //动态代理
        //代理对象跟被代理对象实现了相同的接口
        SellComputer proxyInstance = (SellComputer) Proxy.newProxyInstance(lenovoComputer.getClass().getClassLoader()
                , lenovoComputer.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        System.out.println("专车接送");
                        if(method.getName().equals("sell")){
                            double money = (double) args[0];
                            money = money * 0.85;
                            //真实对象lenovoComputer返回值
                            String obj = (String) method.invoke(lenovoComputer, money);
                            System.out.println("三年保修");
                            return obj+"鼠标";
                        }else{
                            Object obj = method.invoke(lenovoComputer, args);
                            return obj;
                        }
                    }
                });

        String sell1 = proxyInstance.sell(8000.00);
        System.out.println(sell1);
        proxyInstance.show();


    }
}
