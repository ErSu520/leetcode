package com.flash.easy;


import java.util.Arrays;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 */
public class RepeatNumberOfArray {

    /**
     * 先排序 在查找是否有相邻的相同数字
     * 时间复杂度太高
     * @param nums
     * @return
     */
    static int solution1(int[] nums){
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 使用数组作为哈希表来去重
     * @param nums
     * @return
     */
    static int solution2(int[] nums){
        int[] stack = new int[nums.length];
        for(int num : nums){
            if(stack[num] == 1) return num;
            stack[num] = 1;
        }
        return -1;
    }

    /**
     * 原地置换 遇到前往的位置有相同数字，则出现了重复
     * 时间最短
     * @param nums
     * @return
     */
    static int solution(int[] nums){
        int temp ;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == i) continue;
            if(nums[i] == nums[nums[i]]) return nums[i];
            temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
            i--;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 2, 1, 1, 0}));
    }

}
