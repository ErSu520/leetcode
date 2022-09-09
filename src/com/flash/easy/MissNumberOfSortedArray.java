package com.flash.easy;

public class MissNumberOfSortedArray {

    static int solution(int[] nums) {
        int left =0, middle, right = nums.length;

        while(left < right){
            middle = (left + right) / 2;
            if(nums[middle] > middle){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }

        right += right == nums.length ? -1 : 0;
        return nums[right] == right ? right + 1 : right - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1}));
    }

}
