package com.leetcode.string;

import java.util.ArrayList;

/**
 * Created by Administrator on 2020/4/12.
 */
public class DeleteElement {

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE % 10;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE/10);
        System.out.println(i);
        int i1 = Integer.MIN_VALUE % 10;
        System.out.println(i1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE/10);

        ArrayList<StringBuilder> stringBuilders = new ArrayList<>(3);
        System.out.println(stringBuilders.size());
        StringBuilder stringBuilder = stringBuilders.get(0);
        System.out.println(stringBuilder);

    }
    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

      

     示例 1:

     给定数组 nums = [1,1,2],

     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

     你不需要考虑数组中超出新长度后面的元素。
     示例 2:

     给定 nums = [0,0,1,1,1,2,2,3,3,4],

     函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

     你不需要考虑数组中超出新长度后面的元素。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<=1){
            return len;
        }
        int target=0;
        for(int right=1;right<=len-1;right++){
            if(nums[right-1]!=nums[right]){
                nums[target+1]=nums[right];
                target++;
            }
        }
        return target+1;

    }

    /**
     * 27. 移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

     不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

     元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

      

     示例 1:

     给定 nums = [3,2,2,3], val = 3,

     函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

     你不需要考虑数组中超出新长度后面的元素。
     示例 2:

     给定 nums = [0,1,2,2,3,0,4,2], val = 2,

     函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

     注意这五个元素可为任意顺序。

     你不需要考虑数组中超出新长度后面的元素。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/remove-element
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        while(i<len){
            if(nums[i]==val){
                nums[i]=nums[len-1];
                len--;
            }else{
                i++;
            }
        }
        return len;
    }
}

