package com.leetcode.string;

/**
 * 4.寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0
 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMidInTwoArrays4 {

    public static void main(String[] args) {
        int[] nums1 ={1};
        int[] nums2 = {2,3,4,5,6};
        findMedianSortedArrays(nums1,nums2);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        int mid = sum/2;
        if(sum%2==0){
            return ((double)findKth(nums1, nums2, 0, 0, mid) + (double)findKth(nums1, nums2, 0, 0, mid+1))/2;
        }else{
            return findKth(nums1, nums2, 0, 0, mid+1);
        }
    }

    public static double findKth(int[] nums1, int[] nums2, int l1, int l2, int mid){
        if(l1>nums1.length-1) return nums2[l2+mid-1];
        if(l2>nums2.length-1) return nums1[l1+mid-1];

        if(mid==1){
            return nums1[l1]<nums2[l2]?nums1[l1]:nums2[l2];
        }

        int mid1 = l1+mid/2-1<nums1.length?nums1[l1+mid/2-1]:Integer.MAX_VALUE;
        int mid2 = l2+mid/2-1<nums2.length?nums2[l2+mid/2-1]:Integer.MAX_VALUE;

        if(mid1<mid2){
            return findKth(nums1, nums2, l1+mid/2, l2, mid-mid/2);
        }else {
            return findKth(nums1, nums2, l1, l2+mid/2, mid-mid/2);
        }
    }
}
