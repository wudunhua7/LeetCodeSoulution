package com.leetcode.string;

import java.util.*;

/**
 * 49. 字母异位词分组
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。
 */
public class SimpleString49 {
    //通过排序将字符串排序，判断是否是异位字符串
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map= new HashMap();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortString=String.valueOf(chars);
            if(!map.containsKey(sortString)){
                map.put(sortString, new ArrayList<String>());
            }
            map.get(sortString).add(str);
        }

        return new ArrayList(map.values());
    }
}
