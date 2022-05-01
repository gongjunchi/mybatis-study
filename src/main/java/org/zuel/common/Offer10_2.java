package org.zuel.common;

public class Offer10_2 {

    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] % 1000000007 + dp[i-2] % 1000000007) % 1000000007;
        }
        return dp[n];
    }

    // 递归写法
    public int numWays1(int n) {
        if (n < 2) {
            return 1;
        }
        return numWays1(n-1) + numWays1(n-2);
    }

    public static void main(String[] args) {
        Offer10_2 offer10_2 = new Offer10_2();
        System.out.println(offer10_2.numWays(7));
    }
}
