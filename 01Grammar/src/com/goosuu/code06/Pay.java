package com.goosuu.code06;

public interface Pay {
    public static final int MONEY = 1000;
    public abstract void buy();
    void pay();
    //新添加退款流程
    public default  void back(){
        checkGoods();
        System.out.println("退款流程");
    }

    //新添加运送流程
    public default  void transfer(){
        checkGoods();
        System.out.println("运送流程");
    }

    //添加静态方法
    public static void checkMoney(){
        System.out.println("购买时，需要对人民币进行验证是否是假钞");
    }

    //添加私有方法
    private void checkGoods(){
        System.out.println("检查货物");
    }

}
