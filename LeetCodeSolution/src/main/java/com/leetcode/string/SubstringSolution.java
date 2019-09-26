package com.leetcode.string;

import java.util.*;

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

    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

     通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

     示例 1:

     输入: 3
     输出: "III"
     示例 2:

     输入: 4
     输出: "IV"
     示例 3:

     输入: 9
     输出: "IX"
     示例 4:

     输入: 58
     输出: "LVIII"
     解释: L = 50, V = 5, III = 3.
     示例 5:

     输入: 1994
     输出: "MCMXCIV"
     解释: M = 1000, CM = 900, XC = 90, IV = 4.

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/integer-to-roman
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num 输入阿拉伯数字
     * @return 输出罗马数字字符串
     */
    public static String intToRoman(int num) {
        int[] nums={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(start < nums.length){
            while (num >= nums[start]){
                sb.append(romans[start]);
                num-=nums[start];
            }
            start++;
        }
        return sb.toString();
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

     通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

     示例 1:

     输入: "III"
     输出: 3
     示例 2:

     输入: "IV"
     输出: 4
     示例 3:

     输入: "IX"
     输出: 9
     示例 4:

     输入: "LVIII"
     输出: 58
     解释: L = 50, V= 5, III = 3.
     示例 5:

     输入: "MCMXCIV"
     输出: 1994
     解释: M = 1000, CM = 900, XC = 90, IV = 4.

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/roman-to-integer
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s 罗马字符串
     * @return 阿拉伯数字
     */
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans=0;
        for(int i=0; i<s.length();){
            if(i+1<s.length() && map.containsKey(s.substring(i,i+2))){
                ans+=map.get(s.substring(i, i+2));
                i+=2;
            }else{
                ans+=map.get(s.substring(i, i+1));
                i+=1;
            }
        }
        return  ans;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:

     所有输入只包含小写字母 a-z 。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/longest-common-prefix
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs 输入字符串数组
     * @return  返回最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        char temp = 0;
        boolean firstSetFlag = false;

        boolean flag = true;
        int i=0;
        while(flag){
            for(String str:strs){
                if(i>=str.length()){
                    flag = false;
                    break;
                }
                if(!firstSetFlag){
                    firstSetFlag=true;
                    temp=str.charAt(i);
                }else{
                    if(temp == str.charAt(i)){
                        continue;
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                i++;
                firstSetFlag=false;
                sb.append(temp);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
//        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
//        System.out.println(stringStringHashMap.size());
//        Integer[] myarray = {1,2,3};
//        List<Integer> integers = Arrays.asList(myarray);
////        double d = 1d-0.9d;
////        System.out.println(d);
//        ArrayList<String> strings = new ArrayList<String>(Arrays.asList("a", "b"));
//        for (String s: strings) {
//            if ("b".equals(s)){
//                strings.remove(s);
//            }
//        }
        System.out.println(letterCombinations("03993"));
    }

    //1.精度丢失 bigdecimal为什么不会
    //2.string为什么final
    //3.为啥不能再foreach中remove add
    //4.实现数据结构
}
