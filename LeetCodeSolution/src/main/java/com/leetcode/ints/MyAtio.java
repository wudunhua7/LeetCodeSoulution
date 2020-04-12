package com.leetcode.ints;

/**
 * Created by Administrator on 2020/4/13.
 */
public class MyAtio {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
    }
    public static int myAtoi(String str) {
        //如果空，或则trim长度为零 返回0；
        if(str==null||str.trim().length()==0) return 0;

        char[] strs=str.trim().toCharArray();
        int result=0;
        int max=Integer.MAX_VALUE/10;
        int maxPop=Integer.MAX_VALUE%10;
        int min=Integer.MIN_VALUE/10;
        int minPop=Integer.MIN_VALUE%10;
        int negative=1;
        for(int i=0;i<strs.length;i++){
            if(i==0 && strs[i]=='+') continue;
            if(i==0 && strs[i]=='-') {
                negative=-1;
                continue;
            }

            int pop=strs[i]-'0';
            if(pop>=0&&pop<=9){
                if(result*negative>max||(result*negative==max&&pop*negative>=maxPop)) return Integer.MAX_VALUE;
                if(result*negative<min||(result*negative==min&&pop*negative<=minPop)) return Integer.MIN_VALUE;
                result=result*10+pop;
            }else{
                return result*negative;
            }
        }

        return result*negative;
    }

}
