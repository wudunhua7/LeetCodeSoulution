package com.leetcode.string;

/**
 * Created by dun on 2020/4/6.
 */
public class MergeList21 {

    public static class ListNode{
        public static int val;
        public static ListNode next;
        public ListNode(int x){ val = x; }
    }


    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

     示例：

     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode target = new ListNode(0);
        ListNode currentNode = target;
        while(l1!=null||l2!=null){
            if(l1==null) {
                currentNode.next = new ListNode(l2.val);
                currentNode = currentNode.next;
                l2=l2.next;
                continue;
            }
            if(l2==null) {
                currentNode.next = new ListNode(l1.val);
                currentNode = currentNode.next;
                l1=l1.next;
                continue;
            }
            if(l1.val<l2.val){
                currentNode.next = new ListNode(l1.val);
                l1=l1.next;
            }else{
                currentNode.next = new ListNode(l2.val);
                l2=l2.next;
            }
            currentNode = currentNode.next;
        }
        return target.next;
    }
}
