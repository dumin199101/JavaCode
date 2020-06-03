package com.goosuu.code11;

/**
 * 异常：
 *   Throwable
 *      Error:无法解决的
 *      Exception:可以解决的
 *         RuntimeException:运行期异常，可以不用处理，将异常抛给JVM处理
 *            NullPointerException
 *            ArrayIndexOutofBoundsException
 *   Exception异常处理：
 *      throws/throw:交给别人处理，最终交给JVM处理,代码会终止执行。
 *        使用：方法声明时使用
 *        格式：throws xxxException1,xxxException2
 *
 *      try...catch:自己处理，遇到异常代码继续执行。
 *        格式：
 *           try{
 *               可能出现问题代码
 *           }catch(异常类名 变量名){
 *               异常信息
 *           }catch(异常类名 变量名){
 *                异常信息
 *           }finally{
 *               最终执行的代码
 *           }
 *
 *   throw抛出异常：
 *      格式：throw new xxxException()
 *
 *   Throwable类三个处理异常方法：
 *      getMessage():/ by zero
 *      toString():java.lang.ArithmeticException: / by zero
 *      printStackTrace():默认调用,包括位置信息
 *
 *   一个try多个catch:子类异常位于父类异常前边
 *
 *
 *
 */
public class ExceptionDemo {
    public static void main(String[] args) throws MyException {
       int i = 110;
       try {
            int result = deal(i);
            System.out.println(result);
       } catch (ArithmeticException e) {
           e.printStackTrace();
           System.out.println(e.getMessage());
           System.out.println(e.toString());
       }finally {
           System.out.println("World");
       }
       System.out.println("Hello");
       System.out.println("自定义异常");
       throw new MyException("自定义异常");
    }

    public static int deal(int num) throws ArithmeticException{
        return num / 0;
    }
}


