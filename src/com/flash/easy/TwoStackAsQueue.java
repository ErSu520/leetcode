package com.flash.easy;

import java.util.Stack;

public class TwoStackAsQueue {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(3);
//        queue.deleteHead();
    }

}

class CQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        if(stack2.size() != 0){
            while(stack2.size() != 0){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(value);
        System.out.println(stack1);
    }

    public int deleteHead() {
        System.out.println(stack1);
        if(stack1.size() != 0){
            while(stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}