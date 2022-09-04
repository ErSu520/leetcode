package com.flash.easy;


/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 数组的数取值为 [0, 13]
 */
public class SerialPoker {

    static boolean solution(int[] nums){
        int[] map = new int[14];
        int min = 14, max = 0;

        for(int n : nums){
            if(n == 0)continue;
            if(map[n] == 1){
                return false;
            }
            map[n] = 1;
            min = n < min ? n : min;
            max = n > max ? n : max;
        }
        if(max - min > 4){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 3, 2, 5}));
    }

}
