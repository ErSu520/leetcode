package com.flash.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerialArrayAsAdditionToS {

    static int[][] solution(int target) {
        if(target < 3){
            return new int[0][0];
        }
        List<int[]> array = new ArrayList<>();
        int left = 1, right = 2, addition = 3, max = target/2+1;
        while(right <= max){
            System.out.println(left + " " + right + " " + addition);
            if(addition < target){
                addition += ++right;
                continue;
            }
            // 存储序列
            if(addition == target){
                int[] range = new int[right - left + 1];
                for(int i=left;i<=right;i++){
                    range[i-left] = i;
                }
                array.add(range);
            }
            // 控制逻辑
            addition -= left++;
        }
        return array.toArray(new int[array.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(9)));
    }

}
