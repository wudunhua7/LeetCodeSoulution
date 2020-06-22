package com.leetcode.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//1.延时加载
//2.线程安全
//3.反射攻击漏洞
public class SingleByDoubleCheck {
    public static SingleByDoubleCheck SINGLE_BY_DOUBLE_CHECK = null;

    private SingleByDoubleCheck() throws Exception {
        //防止反射攻击
        if (SINGLE_BY_DOUBLE_CHECK!=null){
            throw new Exception();
        }
    }

    public static SingleByDoubleCheck getInstance() throws Exception {
        if (SINGLE_BY_DOUBLE_CHECK == null) {
            synchronized (SingleByDoubleCheck.class) {
                if (SINGLE_BY_DOUBLE_CHECK == null) {
                    SINGLE_BY_DOUBLE_CHECK = new SingleByDoubleCheck();
                }
            }
        }
        return SINGLE_BY_DOUBLE_CHECK;
    }

    public static void main(String[] args) throws Exception {
//        Class<?> aClass = Class.forName("com.leetcode.single.SingleByDoubleCheck");
//        Constructor<?> constructor = aClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        //1.
//        SingleByDoubleCheck instance = SingleByDoubleCheck.getInstance();
//        //2.反射调用在1.之后才能防止反射攻击,在1.之前仍能绕过攻击
//        SingleByDoubleCheck o = (SingleByDoubleCheck)constructor.newInstance();
//
//        System.out.println(o==instance);


        Class<?> bClass = Class.forName("com.leetcode.single.SingleEnum");
        Constructor<?> constructorB = bClass.getDeclaredConstructor();
        constructorB.setAccessible(true);

        //2.反射调用在1.之后才能防止反射攻击,在1.之前仍能绕过攻击
        SingleEnum b = (SingleEnum)constructorB.newInstance();
    }

}
