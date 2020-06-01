package com.goosuu.code06;

/**
 *  接口：接口是抽象类的延伸，接口中的所有抽象方法都没有方法体，与抽象方法相比
 *       无需所有子类实现，只需有需要的子类实现即可，可以自定义独有特性。
 *  接口格式：修饰符 interface 接口名称{}
 *  接口中的方法都是抽象方法，可省略public abstract关键字
 *
 *  类与接口可以多实现，使用implements关键字
 *  接口之间可以实现多继承
 *  类与接口之间如果有方法冲突，优先使用类中的方法
 *
 *  默认方法：为解决接口升级导致接口实现类必须重写的问题，接口提供了带方法体的默认方法,会被实现类继承
 *  格式：public default 返回值类型 方法名{方法体}
 *  默认方法也可以被实现类重写！
 *
 *  静态方法：public static 返回值类型 方法名(参数列表){方法体}
 *  调用：接口名称.静态方法名
 *
 *  私有方法：
 *    普通私有方法：解决多个默认方法间代码重复问题
 *    格式：private 返回值类型 方法名(参数列表){方法体}
 *    静态私有方法：解决多个静态方法间代码重复问题
 *    格式：private static 返回值类型 方法名(参数列表){方法体}
 *
 *  接口常量
 *    格式：public static final 数据类型 常量名
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        PayImpl pay = new PayImpl();
        pay.buy();
        Pay.checkMoney();
        pay.pay();
        pay.back();
        pay.transfer();
        System.out.println("初始化金额："+Pay.MONEY);

    }
}
