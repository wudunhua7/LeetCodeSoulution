package com.leetcode.basic;

/**
 * Created by dun on 2020/6/4.
 */
public class Outer {
    private String o1="o1";

    public void outerTest(){
        System.out.println(new Inner1().i1); //外部类,必须通过对象访问内部非静态成员变量
    }

    public static class Inner1{

        private String i1="i1";

        public void inner1Test(){
            System.out.println(new Outer().o1); //静态内部类,要通过对象访问外部类的非静态成员变量
        }

        public class Inner2{
            private String i2="i2";

            public void inner2Test(){
                System.out.println(); //非静态内部类,可以访问外部类的所有成员变量
            }
        }
    }
}
