package com.leetcode.string;

import org.junit.Test;

/**
 * Created by Administrator on 2019/9/1.
 */
public class SubstringSolutionTest {

    @Test
    public void longestUnduplicatedSubstringLengthTest() {
        String s="abcdaefgabcdk";
        String s1="aaaa";
        int i = new SubstringSolution().longestUnduplicatedSubstringLength(s);
        int i1 = new SubstringSolution().longestUnduplicatedSubstringLength(s1);
        System.out.println(i);
        System.out.println(i1);
    }
}
