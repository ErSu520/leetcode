package com.flash.easy;

public class MinValueOfRotateArray {

    static int solution(int[] numbers) {
        int left = 0, right = numbers.length-1, middle = right / 2;
        while(left < right){
            middle = (left + right) / 2;
            if(numbers[middle] < numbers[right]){
                right = middle;
            }else if(numbers[middle] > numbers[right]){
                left = middle + 1;
            }else{
                right--;
            }
        }
        return numbers[right];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 5}));
    }

}
