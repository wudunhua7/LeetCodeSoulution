package com.leetcode.ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2020/4/19.
 */
public class TargetSum {

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

     注意：答案中不可以包含重复的三元组。
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

     满足要求的三元组集合为：
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/3sum
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(len<3){
            return lists;
        }
        //排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            //如果大于零 后面相加肯定大于零，不在有肯能相加==0
            if(nums[i]>0){
                break;
            }
            //去重，如果等于前面的数，只肯能找到相同的数，跳过
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            int target = 0-nums[i];
            //双指针找目标两数之和
            for(int left=i+1,right=nums.length-1;left<right;){
                int sum = nums[left]+nums[right];
                if(sum==target){
                    List<Integer> targetList = new ArrayList<Integer>();
                    targetList.add(nums[i]);
                    targetList.add(nums[left]);
                    targetList.add(nums[right]);
                    lists.add(targetList);
                    //去重
                    for(;left<right;left++,right--){
                        if(nums[left+1]==nums[left] && nums[right-1]==nums[right]){
                            continue;
                        }
                        break;
                    }
                    left++;
                    right--;
                    continue;
                }
                if(sum>target){
                    right--;
                    continue;
                }
                if(sum<target){
                    left++;
                    continue;
                }
            }

        }
        return lists;
    }
}
