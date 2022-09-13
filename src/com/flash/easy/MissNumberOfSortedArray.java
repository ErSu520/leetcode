package com.flash.easy;

public class MissNumberOfSortedArray {

    static int solution(int[] nums) {
        int left =0, middle, right = nums.length -1;

        while(left < right){
            middle = (left + right) / 2;
            if(nums[middle] > middle){
                right = middle;
            }else{
                left = middle + 1;
            }
        }

        return nums[right] == right ? right + 1 : right;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2}));
    }

}
