package com.leetcode.ints;

/**
 * Created by Administrator on 2020/4/19.
 */
public class NumsPermutation {

    /**
     * 31. 下一个排列
     实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

     如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

     必须原地修改，只允许使用额外常数空间。

     以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     1,2,3 → 1,3,2
     3,2,1 → 1,2,3
     1,1,5 → 1,5,1
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        int len = nums.length;
        if(len < 2) return;

        int i=len-1;
        //从末尾寻找第一个下降的位置
        for(;i>=1;i--){
            if(nums[i]<=nums[i-1]) continue;
            else break;
        }

        //如果i==0,表示没有出现下降，是最大排列，直接逆序返回
        if(i==0){
            reverse(nums,0, len-1);
            return;
        }

        //从j开始，寻找比i-1更大的最大索引
        int j=i;
        for(; j<len;j++){
            if(nums[i-1]<nums[j]) continue;
            else break;
        }
        //交换位置
        swap(nums, i-1, j-1);

        //i-1后面的数在逆序；
        reverse(nums, i, len-1);
        return;

    }

    private void swap(int[] nums, int i, int j){
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
    }

    private void reverse(int[] nums, int left, int right){
        for(;left<right;left++,right--){
            swap(nums, left, right);
        }
    }
}
