package com.goosuu.code09;

public class LenovoComputer implements SellComputer{
    @Override
    public String sell(double money) {
        System.out.println("卖出一台价格为："+money+"的电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("联想笔记本展示");
    }
}
