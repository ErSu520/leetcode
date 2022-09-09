package com.flash.easy;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class FindNumberCountFromSortedArray {

    static  int solution(int[] nums, int target) {
        int left = 0, middle, right = nums.length;
        int index = -1;

        while(left<right){
            middle = (left + right)/2;
            if(nums[middle] < target){
                left = middle + 1;
            }else if(nums[middle] > target){
                right = middle;
            }else{
                index = middle;
                break;
            }
        }

        System.out.println(index);
        if(index > -1){
            int count = 1;
            for(int i=index-1;i>-1;i--){
                if(nums[i] == target){
                    count++;
                    continue;
                }
                break;
            }
            for(int i=index+1;i<nums.length;i++){
                if(nums[i] == target){
                    count++;
                    continue;
                }
                break;
            }
            return count;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3}, 1));
    }

}
