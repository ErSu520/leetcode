package com.flash.easy;

import java.util.Arrays;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fibonacci {

    public static int solution(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        n++;
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            if(i == 0) {
                array[i] = 0;
                continue;
            }
            if(i == 1) {
                array[i] = 1;
                continue;
            }
            array[i] = (array[i-1] + array[i-2]) % 1000000007;
        }
        return array[n-1];
    }

    public static void main(String[] args) {
        System.out.println(solution(48));
    }

}
