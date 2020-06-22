package com.leetcode.basic;

/**
 * Created by dun on 2020/6/4.
 */
public class Try {
    public static void main(String[] args) {
        //System.out.println(tryi());
    }

    //finally中有return,一定义finally返回为准; finally只修改,无return,只当修改的值是返回引用对象里的成员值才能生效
    private static Test tryi() {
        Test i= new Test(1);
        //int i=1;
        try {
            //throw new Exception();
            return i;
        }catch (Exception e){
            return i;
        }finally {
            i.setAge(2);//i=2;
            //return i;
        }
    }

    public static class Test{
        public int age;

        public Test(int age){
            this.age=age;
        }
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "age=" + age +
                    '}';
        }

    }
}
