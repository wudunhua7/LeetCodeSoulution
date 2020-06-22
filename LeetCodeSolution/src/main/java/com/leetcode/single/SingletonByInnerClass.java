package com.leetcode.single;

//1.延时加载
//2.线程安全
//3.反射攻击漏洞
public class SingletonByInnerClass {
    public static class SingletonInnerClass {
        public static final SingletonByInnerClass SINGLETON_BY_INNER_CLASS = new SingletonByInnerClass();
    }

    private SingletonByInnerClass() {

    }

    public static SingletonByInnerClass getInstance() {
        return SingletonInnerClass.SINGLETON_BY_INNER_CLASS;
    }
}
