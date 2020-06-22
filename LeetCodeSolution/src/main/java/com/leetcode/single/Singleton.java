package com.leetcode.single;

import com.leetcode.basic.Outer;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

//非延迟加载
//线程安全
public class Singleton {
    public static final Singleton singleton = new Singleton();

    private Singleton() {
        new Outer.Inner1().new Inner2();
    }

    public static Singleton getSingleton() {
        return singleton;
    }

}
