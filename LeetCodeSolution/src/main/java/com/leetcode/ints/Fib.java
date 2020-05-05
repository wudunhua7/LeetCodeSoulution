package com.leetcode.ints;

import sun.management.Sensor;

/**
 * Created by Administrator on 2020/4/20.
 */
public class Fib {

    public static void main(String[] args) {
        fib0(7);
    }
    public static int fib0(int N) {
        if (N <= 1) {
            return N;
        }
        return fib0(N-1) + fib0(N-2);
    }

    public int fib1(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
    }

    public int fib2(int N) {
        if(N<=2) return 1;
        int first=1;
        int second=1;
        int target=0;
        for(int i=3;i<=N; i++){
            target=first+ second;
            first=second;
            second=target;
        }
        return target;
    }

    static class Solution {
        public static void main(String[] args) {
            int[] nums= {-1,4,1,-4,0,2,3,4,3,8,9};
            firstMissingPositive(nums);
        }
        public static int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // 基本情况
            int contains = 0;
            for (int i = 0; i < n; i++)
                if (nums[i] == 1) {
                    contains++;
                    break;
                }

            if (contains == 0)
                return 1;

            // nums = [1]
            if (n == 1)
                return 2;

            // 用 1 替换负数，0，
            // 和大于 n 的数
            // 在转换以后，nums 只会包含
            // 正数
            for (int i = 0; i < n; i++)
                if ((nums[i] <= 0) || (nums[i] > n))
                    nums[i] = 1;

            // 使用索引和数字符号作为检查器
            // 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
            // 如果 nums[2] 是正数 表示数字 2 没有出现
            for (int i = 0; i < n; i++) {
                int a = Math.abs(nums[i]);
                // 如果发现了一个数字 a - 改变第 a 个元素的符号
                // 注意重复元素只需操作一次
                if (a == n)
                    nums[0] = - Math.abs(nums[0]);
                else
                    nums[a] = - Math.abs(nums[a]);
            }

            // 现在第一个正数的下标
            // 就是第一个缺失的数
            for (int i = 1; i < n; i++) {
                if (nums[i] > 0)
                    return i;
            }

            if (nums[0] > 0)
                return n;

            return n + 1;
        }
    }

}
