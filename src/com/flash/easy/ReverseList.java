package com.flash.easy;

import com.flash.common.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseList {

    static ListNode solution(ListNode head){
        ListNode reverse = null, temp = null;

        while (head != null){
            temp = head.next;
            head.next = reverse;
            reverse = head;
            head = temp;
        }

        return reverse;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createListWithoutHeader(new int[]{1, 2, 3, 4, 5});
        ListNode reverseHead = solution(head);

        while (reverseHead != null){
            System.out.print(reverseHead.value);
            System.out.print("  ");
            reverseHead = reverseHead.next;
        }
    }

}
