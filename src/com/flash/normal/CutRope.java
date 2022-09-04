package com.flash.normal;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {

    static int max = 1;

    static int next(int result, int number){
        for(int i =1;i<number;i++){
            int maybe = i * next(result * i, number - i);
            System.out.println(maybe);
            if(max < maybe){
                max = maybe;
                System.out.println(max);
            }
        }
        return 1;
    }

    public static void main(String[] args){
        System.out.println(next(1, 10));
    }
}
