package com.leetcode.string;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.List;

/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class TwoStringMultiply43 {

    public class Cookie {
        private String domain;
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        BigInteger x;


        Object read = JSONPath.read("null", "$.data.cookies");
        List<Cookie> cookies = JSONObject.parseArray(JSONObject.toJSONString(read), Cookie.class);

        for (Cookie cookie : cookies) {
            System.out.println("args = [" + args + "]");
        }


        String multiply = multiply(s1, s2);
        System.out.println("args = [" + multiply + "]");
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String result = "0";

        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int length1 = num1.length();
        int length2 = num2.length();

        for (int i = length1 - 1; i >= 0; i--) {
            //进位标识
            int plus = 0;
            String temp = "";
            //补零
            for (int k = length1 - i - 1; k > 0; k--) {
                temp = temp + "0";
            }
            //循环相乘
            for (int j = length2 - 1; j >= 0; j--) {
                int total = (nums1[i] - '0') * (nums2[j] - '0') + plus;
                temp = total % 10 + temp;
                plus = total / 10;
            }

            //如果进位>0，加入
            if (plus > 0) {
                temp = plus + temp;
            }


            result = addTwoString(result, temp);
        }
        return result;
    }

    private static String addTwoString(String s1, String s2) {
        char[] nums1 = s1.toCharArray();
        char[] nums2 = s2.toCharArray();
        int length1 = s1.length();
        int length2 = s2.length();
        int plus = 0;
        String result = "";
        for (int i = length1 - 1, j = length2 - 1; i >= 0 || j >= 0; i--, j--) {
            char value1 = i >= 0 ? nums1[i] : '0';
            char value2 = j >= 0 ? nums2[j] : '0';
            int total = (value1 - '0') + (value2 - '0') + plus;
            result = total % 10 + result;
            plus = total / 10;
        }

        if (plus > 0) {
            result = plus + result;
        }
        return result;
    }

}
