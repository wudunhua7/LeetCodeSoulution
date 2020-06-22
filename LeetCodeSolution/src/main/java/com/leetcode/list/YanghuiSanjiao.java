package com.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dun on 2020/6/16.
 */
public class YanghuiSanjiao {

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



     在杨辉三角中，每个数是它左上方和右上方的数的和。

     示例:

     输入: 5
     输出:
     [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/pascals-triangle
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for(int i=1; i<=numRows;i++){
            List<Integer> line = new ArrayList<Integer>();
            for(int j=1;j<=i;j++){
                if(j==1 || j==i){
                    line.add(1);
                }else{
                    line.add(results.get(i-2).get(j-1)+results.get(i-2).get(j-2));
                }
            }
            results.add(line);
        }
        return results;
    }
}
