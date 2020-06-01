package com.goosuu.code08;

/**
 *  内部类：
 *    成员内部类
 *        修饰符 class 类名{
 *            修饰符 class 类名{
 *
 *            }
 *        }
 *        规则：内用外，随意使用，外用内，需要使用内部类对象
 *        生成文件名：Body$Heart.class
 *        调用：
 *          间接方式：外部类方法中使用内部类，main调用外部类方法
 *          直接方式：外部类名称.内部类名称 对象名 = new 外部名称().new 内部名称();
 *        访问变量：
 *           System.out.println(num); //局部变量
 *           System.out.println(this.num);  //内部类成员变量
 *           System.out.println(Body.this.num);  //外部类成员变量
 *
 *    局部内部类
 *      只有当前所属的方法可以使用
 *      修饰符 class 类名{
 *          修饰符 返回值类型 外部类方法(参数列表){
 *              class 局部内部类名称{
 *
 *              }
 *          }
 *      }
 *      局部内部类中，外部类局部变量要用final修饰，这是由生命周期决定的，变量存储在栈内存，类存储在堆内存。
 *
 *      匿名内部类:
 *         如果接口实现类如果只使用一次，那么就可以使用匿名内部类
 *         匿名内部类省略了实现类，匿名对象省略了对象名称
 *         接口 接口名称 = new 接口(){重写接口抽象方法}
 *         注意：如果匿名内部类只有一个方法需要重写，调用方式可以简化为：
 *            new 接口(){重写接口抽象方法}.method();
 *
 *
 *   跟修饰符关系：
 *     外部类:public default
 *     成员内部类：public protected default private
 *     局部内部类：什么都不能用
 *
 *   类作为方法参数时，说明要向方法中传入该类的对象
 *   类作为方法返回值时，说明该方法要返回一个该类的对象。
 *   抽象类作为方法参数时，说明要传入一个实现抽象类所有抽象方法的子类对象。
 *   抽象类作为方法返回值时，说明需要返回一个实现抽象类所有抽象方法的子类对象。
 *   接口作为方法参数时，说明该方法要传入一个接口实现类对象。
 *   接口作为方法返回值时，说明该方法需要返回一个接口实现类对象。
 *
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        //成员内部类
            //间接方式
            Body body = new Body();
            body.methodBody();
            //直接方式
            Body.Heart bodyheart = new Body().new Heart();
            bodyheart.beat();

            System.out.println("**********************");
            //访问成员内部类变量
            bodyheart.beatNum();

        //局部内部类
        body.methodOuter();

        System.out.println("*******************");

        //匿名内部类
        MyInterface obj = new MyInterface() {
            @Override
            public void eat() {
                System.out.println("eat");
            }

            @Override
            public void sleep() {
                System.out.println("sleep");
            }
        };

        obj.eat();
        obj.sleep();




    }
}
