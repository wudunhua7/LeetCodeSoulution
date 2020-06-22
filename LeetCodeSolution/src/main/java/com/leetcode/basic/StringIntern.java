package com.leetcode.basic;

public class StringIntern {


    //intern逻辑 jdk1.6.常量池有直接返回,没有在常量池中创建对象;jdk 1.7 没有会将引用保存在常量池中
    public static void main(String[] args) {
        //1-----1----
        String a1 = new String("a");//创建了常量池"a", 堆里a1对象两个对象, 返回堆对象
        String a2 = a1.intern(); //直接返回常量池对象,不会在创建对象
        String a3 = "a"; //常量池已有,直接返回常量池对象,不会在创建对象
        System.out.println(a1==a2);//false
        System.out.println(a2==a3);//true
        //1-----1----

        //2.0----2.0----
        String t1 = new String("l")+new String("l"); //常量池"l"对象, 堆"ll"对象,两个匿名对象,共4个对象, 返回堆里"ll"对象
        String t2 = "ll"; //创建常量池对象
        String t3 = t1.intern(); //直接返回常量池对象
        System.out.println(t1==t2);//false
        System.out.println(t2==t3);//true
        //2.0----2.0----

        //2.1----2.1----
        String x1 = new String("x")+new String("x"); //常量池"x"对象, 堆"xx"对象,两个匿名对象,共4个对象, 返回堆里"xx"对象

        String x2 = x1.intern(); //常量池中没有xx, jdk 1.6,常量池在perm(相对较小)区,会直接在常量池中创建xx对象,并返回
                                 // jdk 1.7及以后,常量池从perm区移到堆中,因此常量池无需在创建xx,而是直接将堆中xx的引用存在常量池中,并返回引用
        String x3 = "xx";    //常量池中有xx对象的引用了,1.7直接返回堆中引用,1.6返回常量池对象
        System.out.println(x1==x2);//jdk 1.6 false; jdk1.7 true
        System.out.println(x2==x3);//jdk1.6 true, jdk1.7 true
        //2.1----2.1----

        //3------3-----
        String s1="s";
        String s2="s";
        //String s3=s1+s2; //false
        //String s3=s1+"s"; //false
        String s3="s"+"s"; //true
        String s4="ss";
        System.out.println(s3==s4);

    }
}
