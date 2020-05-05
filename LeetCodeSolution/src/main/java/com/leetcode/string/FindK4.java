package com.leetcode.string;

import java.util.Stack;

/**
 * Created by dun on 2020/4/6.
 */
public class FindK4 {

    public static void main(String[] args) {
        int[] v1 = {1, 2};
        int[] v2 = {3, 4};
        FindK4 findK4 = new FindK4();
        double medianSortedArrays = findK4.findMedianSortedArrays(v1, v2);
        System.out.println("args = [" + args + "]");
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if((len1+len2)%2==0){
            int K = (len1+len2)/2;
            return (findK(nums1,nums2,0,0,K)+findK(nums1,nums2,0,0,K+1))/2;
        }else{
            return findK(nums1, nums2, 0, 0, (len1+len2)/2+1);
        }

    }

    private double findK(int[] nums1, int[] nums2,int index1, int index2, int K){

        if(index1>=nums1.length) return nums2[index2+K-1];
        if (index2>nums2.length) return nums1[index1+K-1];

        if(K==1){
            return Math.min(nums1[index1], nums2[index2]);
        }

        int mid1=index1+K/2-1<nums1.length?nums1[index1+K/2-1]:Integer.MAX_VALUE;
        int mid2=index2+K/2-1<nums2.length?nums2[index2+K/2-1]:Integer.MAX_VALUE;

        if(mid1>mid2){
            return findK(nums1,nums2,index1,index2+K/2, K-K/2);
        }else{
            return findK(nums1,nums2,index1+K/2, index2, K-K/2);
        }
    }
}
