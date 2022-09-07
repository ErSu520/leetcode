package com.flash.easy;

import java.util.Arrays;

public class Fibonacci {

    public static int solution(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

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
            array[i] = (array[n-1] + array[n-2]) % 1000000007;
        }
        System.out.println(Arrays.toString(array));
        return (array[n-1] + array[n-2]) % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(solution(48));
    }

}
