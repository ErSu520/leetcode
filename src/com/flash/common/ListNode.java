package com.flash.common;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int value) {
        this.val = value;
        next = null;
    }

    public static ListNode createList(int[] array){
        ListNode header = new ListNode(-1);
        ListNode rear = header;
        for(int i : array){
            rear.next = new ListNode(i);;
            rear = rear.next;
        }
        return header;
    }

    public static ListNode createListWithoutHeader(int[] array){
        return createList(array).next;
    }


}
