package com.leetcode.ints;

/**
 * 41. 缺失的第一个正数
 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。



 示例 1:

 输入: [1,2,0]
 输出: 3
 示例 2:

 输入: [3,4,-1,1]
 输出: 2
 示例 3:

 输入: [7,8,9,11,12]
 输出: 1


 提示：

 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class FirstMissPositive {
    //未出现的最小正数<=nums.length+1
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        //第一遍判断是否出现1，同时把<=0和>nums.length的值置位1；
        boolean hasOne=false;
        for(int i=0;i<len;i++){
            if(nums[i]==1){
                hasOne=true;
            }
            if(nums[i]<=0||nums[i]>len){
                nums[i]=1;
            }
        }

        //如果没有出现1，则直接返回1；
        if(!hasOne){
            return 1;
        }

        //数组全是1至nums.length的数；
        for(int i=0;i<len;i++){
            //取出位置的值；因为肯能前置位置出现过改变过符号；所以绝对值
            int key= Math.abs(nums[i]);
            //将key值，存在key-1索引位置，绝对值后加负号防止重复出现后又变为正数
            nums[key-1]=-Math.abs(nums[key-1]);
        }

        //现在>0的索引+1，即为未出现的正数
        for(int i=0;i<len;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return len+1;
    }
}
