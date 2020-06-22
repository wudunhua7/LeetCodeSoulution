package com.leetcode.single;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by dun on 2020/5/31.
 */
public class ReflectClass {

    public String name;

    public boolean test0(){
        return true;
    }

    public void test1(){
        System.out.println("show test1");
    }

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.leetcode.single.ReflectClass");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Method[] declaredMethods2 = aClass.getDeclaredMethods();
        Method test0 = aClass.getDeclaredMethod("test0");
        Field[] declaredFields = aClass.getDeclaredFields();


    }
}
