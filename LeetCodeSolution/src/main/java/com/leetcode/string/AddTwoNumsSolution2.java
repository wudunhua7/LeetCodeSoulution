package com.leetcode.string;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class AddTwoNumsSolution2 {

    public static class ListNode{
        public static int val;
        public static ListNode next;
        public ListNode(int x){ val = x; }
    }

    /**
     * 2题目:
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     示例：

     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/add-two-numbers
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode target = new ListNode(0);
        ListNode current = target;
        int plus = 0;
        while(l1!=null||l2!=null){
            int val1=0;
            if(l1!=null){
                val1=l1.val;
                l1=l1.next;
            }
            int val2=0;
            if(l2!=null){
                val2=l2.val;
                l2=l2.next;
            }

            int sum = val1 + val2 +plus;
            plus = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
        }

        if(plus>0){
            current.next=new ListNode(plus);
        }

        return target.next;
    }
    /**
     * ======================================
     */


    /**
     * 445题目:
     * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

      

     你可以假设除了数字 0 之外，这两个数字都不会以零开头。

     进阶:

     如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

     示例:

     输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出: 7 -> 8 -> 0 -> 7
     *
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = reserveToStack(l1);
        Stack<Integer> stack2 = reserveToStack(l2);

        int plus =0;
        ListNode target = new ListNode(0);
        ListNode currentNode = target;
        ListNode pre = null;
        ListNode post = null;
        while((stack1!=null&&!stack1.empty())||(stack2!=null&&!stack2.empty())){
            int val1=0;
            if(stack1!=null&&!stack1.empty()){
                val1=stack1.pop();
            }
            int val2=0;
            if(stack2!=null&&!stack2.empty()){
                val2=stack2.pop();
            }
            int sum = val1+val2+plus;
            post = new ListNode(sum%10);

            currentNode.next=new ListNode(sum%10);
            currentNode = currentNode.next;

            plus=sum/10;
        }

        if(plus>0){
            currentNode.next=new ListNode(plus);
        }

        return reserveRecursion(target.next);

    }

    /**
     * 遍历法反转链表
     * @param l1
     * @return
     */
    public ListNode reserveListNode(ListNode l1){
        ListNode pre=null, post=null;
        while(l1!=null){
            post=l1.next;
            l1.next=pre;
            pre=l1;
            l1=post;
        }
        return pre;
    }

    /**
     * 递归反转链表
     * @param node
     * @return
     */
    public ListNode reserveRecursion(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode temp = node.next;
        ListNode newNode = reserveRecursion(node.next);
        temp.next = node;
        node.next = null;
        return newNode;
    }

    /**
     * 链表转栈
     * @param l1
     * @return
     */
    public Stack<Integer> reserveToStack(ListNode l1){
        Stack<Integer> stack = new Stack();
        while(l1!=null){
            stack.push(l1.val);
            l1=l1.next;
        }
        return stack;
    }


    /**
     *67. 二进制求和
     *
     给你两个二进制字符串，返回它们的和（用二进制表示）。

     输入为 非空 字符串且只包含数字 1 和 0。
     示例 1:

     输入: a = "11", b = "1"
     输出: "100"
     示例 2:

     输入: a = "1010", b = "1011"
     输出: "10101"
      

     提示：

     每个字符串仅由字符 '0' 或 '1' 组成。
     1 <= a.length, b.length <= 10^4
     字符串如果不是 "0" ，就都不含前导零。
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int plus=0;
        String result="";
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
            int value1=i>=0?a.charAt(i)-'0':0;
            int value2=j>=0?b.charAt(j)-'0':0;
            int sum=value1+value2+plus;
            result=sum%2+result;
            plus=sum/2;
        }
        if(plus>0){
            result=plus+result;
        }
        return result;
    }

    /**
     *371. 两整数之和
     *
     不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

     示例 1:

     输入: a = 1, b = 2
     输出: 3
     示例 2:

     输入: a = -2, b = 3
     输出: 1

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/sum-of-two-integers
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int answer=0,carray=0;
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        while(b!=0){
            answer=a^b;
            carray=(a&b)<<1;
            a=answer;
            b=carray;
        }
        return answer;
    }

    /**
     *415. 字符串相加

     给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

     注意：

     num1 和num2 的长度都小于 5100.
     num1 和num2 都只包含数字 0-9.
     num1 和num2 都不包含任何前导零。
     你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/add-strings
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int plus=0;
        StringBuilder result = new StringBuilder("");
        for(int i=num1.length()-1,j=num2.length()-1;i>=0||j>=0;i--,j--){
            int value1=i>=0?num1.charAt(i)-'0':0;
            int value2=j>=0?num2.charAt(j)-'0':0;
            int sum=value1+value2+plus;
            plus = sum/10;
            result.append(sum%10);
        }
        if(plus>0){
            result.append(plus);
        }
        return result.reverse().toString();
    }


    /**
     *989. 数组形式的整数加法
     对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

     给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。



     示例 1：

     输入：A = [1,2,0,0], K = 34
     输出：[1,2,3,4]
     解释：1200 + 34 = 1234
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList();
        int plus=0;
        for(int i=A.length-1,current=K;i>=0||current>0;i--,current/=10){
            int val=i>=0?A[i]:0;
            int sum=val+current%10+plus;
            plus=sum/10;
            result.add(sum%10);
        }
        if(plus>0){
            result.add(plus);
        }
        Collections.reverse(result);
        return result;
    }

}
