package com.leetcode.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dun on 2020/6/4.
 */
public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Integer> list = new ArrayList<Integer>();

        int n = 18 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println("args = [" + n + "]");

        BigDecimal bigDecimal = new BigDecimal("3.112");
        BigDecimal bigDecimal1 = new BigDecimal("-3.112");

        BigDecimal bigDecimal2 = new BigDecimal(3.112d);

        list.add(12);
//这里直接添加会报错
        //list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
//但是通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);
    }
}
