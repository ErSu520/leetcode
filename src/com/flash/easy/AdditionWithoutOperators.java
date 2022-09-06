package com.flash.easy;

public class AdditionWithoutOperators {

    static int solution(int a, int b){
        while (b != 0){
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 2));
    }

}
