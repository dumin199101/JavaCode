package aop1.anno.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class Logger {

    @Pointcut("execution(* aop1.anno.service.impl.*.*(..))")
    private void pct(){}

    @Before("pct()")
    public void logBefore(){
        System.out.println("记录logBefore日志信息");
    }

    @AfterReturning("pct()")
    public void logAfter(){
        System.out.println("记录logAfter日志信息");
    }

    @AfterThrowing("pct()")
    public void logError(){
        System.out.println("记录logError日志信息");
    }

    @After("pct()")
    public void logFinal(){
        System.out.println("记录logFinal日志信息");
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
