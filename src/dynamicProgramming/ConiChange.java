package dynamicProgramming;

import java.util.Arrays;

public class ConiChange {
//    Given an array coins[] represent the coins of different denominations and a target value sum.
//    You have an infinite supply of each of the valued coins{coins1, coins2, ..., coinsm}.
//    Find the minimum number of coins to make the change. If not possible to make a change then return -1.
int dp[][];
    public int minCoins(int coins[], int sum) {
        // Your code goes here
        int n = coins.length;
        dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int r = fun(coins,0,n,sum);
        return (r==Integer.MAX_VALUE)?-1:r;
    }
    int fun(int coins[],int i,int n,int sum){
        if(sum==0){
            return 0;
        }
        if(i>=n || sum<0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int noTake= fun(coins,i+1,n,sum);
        int take = Integer.MAX_VALUE;
        if(coins[i]>0){
            take = fun(coins,i,n,sum-coins[i]);
            if(take!=Integer.MAX_VALUE){
                take++;
            }
        }
        return dp[i][sum]=Math.min(take,noTake);
    }

}
