package com.flash.easy;

import com.flash.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 约瑟夫环
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 */
public class LastNumberOfCircle {

    /**
     * 使用链表来存储所有的数字，自然模拟
     * 超时
     * @param n
     * @param m
     * @return
     */
    static int solution1(int n, int m){
        ListNode head = new ListNode(0);
        ListNode rear = head;
        for(int i=1;i<n;i++){
            rear.next = new ListNode(i);
            rear = rear.next;
        }
        rear.next = head;
        head = rear;
        m -= 1;
        while (head != head.next){
            for(int i=0;i<m;i++){
                head = head.next;
            }
            head.next = head.next.next;
        }
        return head.value;
    }

    /**
     * 用ArrayList来存放所有的数字，ArrayList会自动去除被删除的位置
     * 耗时太长
     * @param n
     * @param m
     * @return
     */
    static int solution2(int n, int m){
        List<Integer> nums = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            nums.add(i);
        }
        int index = n-1;
        while (nums.size() > 1){
            index = (index + m) % nums.size();
            nums.remove(index);
            index -= 1;
        }
        return nums.get(0);
    }

    /**
     * 数学解法
     * @param n
     * @param m
     * @return
     */
    static int solution(int n, int m){

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 1));
    }

}
