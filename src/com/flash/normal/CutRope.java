package com.flash.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {

    static int max = 1;

    static int solution(int n) {
        if(n < 1){
            return 0;
        }
        return rope(n, new ArrayList<>(0), 1);
    }

    static int rope(int n, List<Integer> list, int multi){
        for(int i=0;i<=n;i++){
            List<Integer> array = new ArrayList<>(list);
            array.add(i);

        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution(10));
    }
}
