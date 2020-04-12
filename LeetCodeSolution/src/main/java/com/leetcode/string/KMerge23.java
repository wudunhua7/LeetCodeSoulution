package com.leetcode.string;

import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KMerge23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null||lists.length==0) return null;
        int len = lists.length;
        if(len==1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>(len, (ListNode o1, ListNode o2) -> o1.val-o2.val);

        for(ListNode node:lists){
            if(null==node) continue;
            pq.add(node);
        }

        ListNode dumy= new ListNode(0);
        ListNode currentNode = dumy;
        while(!pq.isEmpty()){
            currentNode.next=pq.poll();
            currentNode=currentNode.next;
            if(currentNode.next!=null) pq.add(currentNode.next);
        }

        return dumy.next;

    }

    /**
     * 分治算法
     * @param lists
     * @return
     */
    public ListNode mergeKListsByDivision(ListNode[] lists) {

        if(lists==null||lists.length==0) return null;
        int len = lists.length;
        while(len>1){
            for(int i=0;i<len/2;i++){
                lists[i]=mergeListNode(lists[i], lists[len-1-i]);
            }
            len=(len+1)/2;
        }
        return lists[0];

    }

    private ListNode mergeListNode(ListNode l1, ListNode l2){
        ListNode dumy=new ListNode(0);
        ListNode currentNode=dumy;
        while(l1!=null||l2!=null){
            if(l1==null) {
                currentNode.next = l2;
                break;
            }
            if(l2==null){
                currentNode.next = l1;
                break;
            }

            if(l1.val<l2.val){
                currentNode.next=l1;
                l1=l1.next;
            }else{
                currentNode.next=l2;
                l2=l2.next;
            }
            currentNode=currentNode.next;
        }

        return dumy.next;
    }

}
