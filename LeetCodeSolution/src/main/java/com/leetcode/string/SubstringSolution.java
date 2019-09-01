package com.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/9/1.
 */
public class SubstringSolution {
    /**
     * 最长不重复子串
     =====================================================
     给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。
     示例 1:
     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:

     输入: "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:

     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
          请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     =====================================================
     */
    public static int longestUnduplicatedSubstringLength(String s){
        int maxLegth = 0;
        if (s == null || s.length()==0){
            return maxLegth;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int left=0,right =0;right<s.length();right++){
            Character key = s.charAt(right);
            if (map.containsKey(key) && map.get(key) >= left){
                left = map.get(key)+1;
            }
            map.put(key, right);
            maxLegth = right-left+1>maxLegth?right-left+1:maxLegth;
        }
        return maxLegth;
    }

    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        change(stringStringHashMap);
        System.out.println(stringStringHashMap.size());
        Integer[] myarray = {1,2,3};
        List<Integer> integers = Arrays.asList(myarray);
//        double d = 1d-0.9d;
//        System.out.println(d);
        ArrayList<String> strings = new ArrayList<String>(Arrays.asList("a", "b"));
        for (String s: strings) {
            if ("b".equals(s)){
                strings.remove(s);
            }
        }
        System.out.println(strings);
    }

    private static void change(HashMap<String, String> stringStringHashMap) {
        //stringStringHashMap=new HashMap<String, String>();
        stringStringHashMap.put("a","b");
    }
    //1.精度丢失 bigdecimal为什么不会
    //2.string为什么final
    //3.为啥不能再foreach中remove add
    //4.实现数据结构
}
