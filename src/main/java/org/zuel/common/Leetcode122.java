package org.zuel.common;

public class Leetcode122 {

    // 贪心
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i] < prices[i+1]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    // 动态规划
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        Leetcode122 leetcode122 = new Leetcode122();
        System.out.println(leetcode122.maxProfit(new int[]{1,2,3,4,5}));
    }
}
