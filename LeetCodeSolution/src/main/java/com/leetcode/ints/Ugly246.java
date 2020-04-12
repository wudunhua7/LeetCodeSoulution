package com.leetcode.ints;

/**
 * Created by Administrator on 2020/4/12.
 */
public class Ugly246 {

    public static void main(String[] args) {
        nthUglyNumber(10);
    }

    /**
     * 264. 丑数 II
     * 编写一个程序，找出第 n 个丑数。

     丑数就是只包含质因数 2, 3, 5 的正整数。

     示例:

     输入: n = 10
     输出: 12
     解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     说明:  

     1 是丑数。
     n 不超过1690。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/ugly-number-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {

        if(n==1) {
            return 1;
        }

        int[] uglys = new int[n];
        uglys[0]=1;
        int i2=0,i3=0,i5=0;
        for(int i=1;i<n;i++){
            uglys[i]=Math.min(Math.min(uglys[i2]*2,uglys[i3]*3), uglys[i5]*5);

            if(uglys[i]==uglys[i2]*2) i2++;
            if(uglys[i]==uglys[i3]*3) i3++;
            if(uglys[i]==uglys[i5]*5) i5++;
        }

        return uglys[n-1];

    }
}
