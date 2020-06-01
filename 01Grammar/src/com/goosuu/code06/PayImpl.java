package com.goosuu.code06;

public class PayImpl implements Pay {
    @Override
    public void buy() {
        System.out.println("购买流程");
    }

    @Override
    public void pay() {
        System.out.println("付款流程");
    }

    @Override
    public void back() {
        System.out.println("退款流程可发起退款");
    }
}
