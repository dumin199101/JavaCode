package com.goosuu.code17;

/**
 *  JDK8新特性之方法引用：
 *    作用：简化Lambda表达式
 *    对象名::成员方法
 *    类名::静态方法
 *    super::父类成员方法
 *    this::本类成员方法
 *    构造方法:类名::new
 *    数组：数组::new
 *
 *
 *
 */
public class MethodReferenceDemo {
   public static void printString(String str,PrintInterface p){
       p.print(str);
   }

   public void show(String str){
       System.out.println(str);
   }

   public static void show2(String str){
       System.out.println(str);
   }

    public void printStr(String str,PrintInterface p){
        p.print(str);
    }
   public void show3(){
       printStr("Java",(s)->{
           this.show(s);
       });
       printStr("JavaEE",this::show);
   }

    public static void main(String[] args) {
       printString("Hello",(s)->{
           MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
           methodReferenceDemo.show(s);
       });
       //简化写法：使用方法引用
       MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
       printString("Hello",methodReferenceDemo::show);
       System.out.println("************************");
       printString("World",MethodReferenceDemo::show2);
       System.out.println("***********************");
       new MethodReferenceDemo().show3();

    }
}
