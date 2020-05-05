package com.leetcode.ints;

public class Solution42 {
    /**
     * 42. 接雨水
     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



     上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

     示例:

     输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     输出: 6
     */
    // 1.当前格子的蓄水ans=min(leftHeightMax,rightHeightMax)-currentHeight;
    // 2.头尾双指针，如果 height[left]<height[right]；说明左右最大值较小的在左边，判断当前left比历史的最大值小，蓄水，或则更新最大值；最后left++;
    // 3.最后职责停留的一定包含整个数组的最大值
    public int trap(int[] height) {
        int leftHeightMax=0;
        int rightHeightMax=0;
        int ans=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftHeightMax){
                    leftHeightMax=height[left];
                }else{
                    ans+=(leftHeightMax-height[left]);
                }
                left++;
            }else{
                if(height[right]>=rightHeightMax){
                    rightHeightMax=height[right];
                }else{
                    ans+=(rightHeightMax-height[right]);
                }
                right--;
            }
        }
        return ans;
    }

    public int trap1(int[] height){
        int len=height.length;
        if(len<=2) return 0;
        //计算每个位置左边的最大值
        int[] leftMaxs=new int[len];
        leftMaxs[0]=height[0];
        for(int left=1;left<len;left++){
            leftMaxs[left]=Math.max(height[left], leftMaxs[left-1]);
        }

        //计算每个位置左边的最大值
        int[] rihtMaxs=new int[len];
        rihtMaxs[0]=height[len-1];
        for(int right=len-2;right>=0;right--){
            rihtMaxs[right]=Math.max(height[right], rihtMaxs[right+1]);
        }

        int ans=0;
        for(int i=1;i<len-1;i++){
            ans+=(Math.min(leftMaxs[i], rihtMaxs[i])-height[i]);
        }
        return ans;
    }

    /**
     *11. 盛最多水的容器
     给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

     说明：你不能倾斜容器，且 n 的值至少为 2。
     */
    public int maxArea(int[] height) {
        int len = height.length;
        if(len<2) return 0;
        int maxArea=0;
        int left=0;
        int right=len-1;
        while(left<right){
            if(height[left]>=height[right]){
                maxArea=Math.max(maxArea, height[right]*(right-left));
                right--;
            }else{
                maxArea=Math.max(maxArea, height[left]*(right-left));
                left++;
            }
        }
        return maxArea;
    }
}
