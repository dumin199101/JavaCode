package com.goosuu.code08;

public class Body { //外部类
    public class Heart{  //成员内部类
        //内部类成员变量
        int num = 20;
        //内部类方法
        public void beat(){
            System.out.println("心脏跳动");
            System.out.println("我叫"+name);
        }

        public void beatNum(){
            //内部类方法局部变量
            int num = 30;
            System.out.println(num); //局部变量
            System.out.println(this.num);  //内部类成员变量
            System.out.println(Body.this.num);  //外部类成员变量
        }
    }
    //外部类成员变量
    private String name;
    int num = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //外部类成员方法
    public void methodBody(){
        // 外部类方法调用内部类方法
        new Heart().beat();
        System.out.println("外部类方法");
    }

    //局部内部类
    public void methodOuter(){
        final int num = 50;
        class Inner{
           int num = 40;
           public void methodInner(){
               System.out.println(num);
           }
        }
        Inner inner = new Inner();
        inner.methodInner();
    }
}
