package com.flash.easy;

import com.flash.common.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class FirstCommonNode {

    /**
     * 首先计算两链表的长度，然后将较长的链表向后挪，接着比较每一个节点
     * 逻辑正确，但方法不够巧妙
     * @param headA
     * @param headB
     * @return
     */
    static ListNode solution(ListNode headA, ListNode headB){
        int countA = 0, countB = 0;
        ListNode A = headA, B = headB;
        while (A != null){
            countA++;
            A = A.next;
        }
        while (B != null){
            countB++;
            B = B.next;
        }
        int size = countA - countB;
        if(size < 0) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            size = countB - countA;
        }
        for(int i=0;i<size;i++){
            headA = headA.next;
        }
        while (headB != null){
            if(headA.value == headB.value){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 使用两个指针来进行循环查找
     * 原理：链表A+B的长度是一定的，因此只需要同时遍历A+B以及B+A，这样就可以找到公共节点了
     * PS：该代码实现不对
     * @param headA
     * @param headB
     * @return
     */
    static ListNode solution1(ListNode headA, ListNode headB){
        ListNode A = headA;
        ListNode B = headB;

        while (A.value != B.value){
            System.out.println(2);
            A = A.next != null ? A.next : headB;
            B = B.next != null ? B.next : headA;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode headA = ListNode.createListWithoutHeader(new int[]{4, 4, 8, 4, 5});
        ListNode headB = ListNode.createListWithoutHeader(new int[]{5, 0, 1, 8, 4, 5});

        ListNode result = solution1(headA, headB);
        System.out.println(result != null ? result.value : null);
    }

}
