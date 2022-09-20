package com.flash.other;

/**
 *
 */
public class BuySomeThing {

    public static int buyCount(int[] prices, int aim){
        if(prices.length==0||aim<=0) {
            return -1;
        }
        int n=prices.length;
        int max=Integer.MAX_VALUE;

        int[][] dp=new int[n][aim+1];

        for(int i=0;i<n;i++) {
            dp[i][0] = 0;
        }

        for(int i=0;i<=aim;i++){
            if(prices[0]==0){
                dp[0][i] = max;
            }else{
                dp[0][i]=i%prices[0]==0?i/prices[0]:max;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=aim;j++){
                int left=max;
                if(j-prices[i]>=0 && dp[i][j-prices[i]]!=max) {
                    left = dp[i][j - prices[i]] + 1;
                }
                dp[i][j]=Math.min(dp[i-1][j], left);
            }
        }

        return dp[n-1][aim]==max?-1:dp[n-1][aim];
    }

    public static void main(String[] args){
        System.out.println(buyCount(new int[]{1, 5, 10, 20, 30, 50, 80}, 100));
    }

}
