package com.leetcode.basic;

//enum被隐式修饰了final,不能被继承,也不能继承class(因为他隐私继承了java.lang.Enum,java不允许多继承)
public enum EnumTest {

    //隐式修饰了public static final
    APPLE(10) {
        @Override
        public void test() {
            System.out.println(this.price);
        }
    }, BANANA(1) {
        @Override
        public void test() {
            System.out.println(this.price);
        }
    };

    public  int price;

    //不能申明为public
    EnumTest(int price) {
        this.price=price;
    }

    //因为enum隐式修饰了final, 所以理论不能直接定义抽象方法,除非枚举内部实现了抽象方法
    public abstract void test();

    public static void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }
}
