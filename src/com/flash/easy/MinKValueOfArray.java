package com.flash.easy;

import java.util.Arrays;

public class MinKValueOfArray {

    static int[] solution(int[] arr, int k) {
        int left = 0, middle = Integer.MAX_VALUE, right = arr.length-1;
        while(middle != k-1){
            middle = quickSort(arr, left, right);
            System.out.println(Arrays.toString(arr));
            if(middle < k){
                left = middle + 1;
            }else if(middle > k){
                right = middle - 1;
            }else {
                break;
            }
        }
//        System.out.println(Arrays.toString(arr));
        return Arrays.copyOfRange(arr, 0, k);
    }

    // 前后皆取
    static int quickSort(int[] arr, int start, int end){
        if(start == end) return start;
        int target = start, value = arr[start];
        while(start <= end){
            System.out.println(Arrays.toString(arr));
            if(target <= start){
                if(arr[end] <= value){
                    arr[target] = arr[end];
                    target = end;
                }
                end--;
            }else{
                if(arr[start] > value){
                    arr[target] = arr[start];
                    target = start;
                }
                start++;
            }
        }
        arr[target] = value;
        return target;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 1}, 2)));
    }

}
