package com.flash.normal;

import java.util.*;

public class CalculatePow {

    static double solution(double x, int n) {
        if(n==0){
            return 1;
        }
        long nn = n;
        if(nn < 0) {
            x = 1 / x;
            nn = -nn;
        }
        double ret = 1;
        long max = 1;
        Map<Long, Double> pow = new HashMap<>();
        pow.put(1L, x);
        for(long i=2;i<=nn&&i>0;i*=2){
            pow.put(i, pow.get(i/2) * pow.get(i/2));
            max = i;
        }
        while(nn > 0){
            if(max > nn){
                max /= 2;
                continue;
            }
            nn -= max;
            ret *= pow.get(max);
            System.out.println(ret);
        }
        System.out.println(nn);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(solution(2.00000, -2147483648));
    }

}
