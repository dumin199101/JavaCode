package aop.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void logBefore(){
        System.out.println("记录logBefore日志信息");
    }

    public void logAfter(){
        System.out.println("记录logAfter日志信息");
    }

    public void logError(){
        System.out.println("记录logError日志信息");
    }

    public void logFinal(){
        System.out.println("记录logFinal日志信息");
    }

    public Object logAround(ProceedingJoinPoint pjp){
        Object res = null;
        try {
            System.out.println("记录logAround日志信息1");
            Object[] args = pjp.getArgs();
            res = pjp.proceed(args);
            System.out.println("记录logAround日志信息2");
            return res;
        } catch (Throwable t) {
            System.out.println("记录logAround日志信息3");
            throw new RuntimeException();
        }finally {
            System.out.println("记录logAround日志信息4");
        }
    }

    /*public Object logAround(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");

            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }*/



}
