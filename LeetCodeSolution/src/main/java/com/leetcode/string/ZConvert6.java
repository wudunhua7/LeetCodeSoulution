package com.leetcode.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

 L   C   I   R
 E T O E S I I G
 E   D   H   N
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);
 示例 1:

 输入: s = "LEETCODEISHIRING", numRows = 3
 输出: "LCIRETOESIIGEDHN"
 示例 2:

 输入: s = "LEETCODEISHIRING", numRows = 4
 输出: "LDREOEIIECIHNTSG"
 解释:

 L     D     R
 E   O E   I I
 E C   I H   N
 T     S     G

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/zigzag-conversion
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZConvert6 {

    /**
     时间复杂度 O(numRows)+O(N)+ O(numRows)=O(N)
     空间复杂度 O(N)
     */
    public String convert2(String s, int numRows) {
        if(s==null || numRows==1 ||s.length()<=numRows) return s;

        int len = s.length();
        char[] arrays=s.toCharArray();

        //初始化数组
        List<StringBuilder> lists = new ArrayList<StringBuilder>(numRows-1);
        for(int i=0;i<numRows;i++){
            lists.add(new StringBuilder());
        }

        boolean growFlag=false;
        int target = 0;
        for(int i=0; i<len;i++){
            StringBuilder sb = lists.get(target);
            sb.append(arrays[i]);

            //判断改变时机
            if(target==0 || target==numRows-1) growFlag=!growFlag;
            target+=(growFlag?1:-1);
        }

        StringBuilder result=new StringBuilder();
        for(StringBuilder temp:lists){
            result.append(temp.toString());
        }

        return result.toString();
    }

    public String convert(String s, int numRows) {
        if(s==null || numRows==1 ||s.length()<=numRows) return s;

        StringBuilder sb = new StringBuilder();
        char[] arrays=s.toCharArray();
        int len=s.length();
        int cycleLen=2*numRows-2;

        for(int i=0;i<numRows;i++){
            for(int j=0;i+j<len;j+=cycleLen){
                sb.append(arrays[i+j]);
                //如果不是头尾行，每轮需要多append异常，位置为j+cycleLen-i
                if(i!=0&&i!=numRows-1&&j+cycleLen-i<len){
                    sb.append(arrays[j+cycleLen-i]);
                }
            }
        }
        return sb.toString();
    }
}
