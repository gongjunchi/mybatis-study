package org.zuel.common;

public class Leetcode121 {

    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int num : prices) {
            minBuy = Math.min(num, minBuy);
            maxProfit = Math.max(maxProfit, num - minBuy);
        }
        return maxProfit;
    }

    // 动态规划
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[][] dp = new int[len][2];
        // 第一天结束，不持有股票，利润为0
        dp[0][0] = 0;
        // 第一天结束，持有股票，由于还没卖出，现金是负的
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 昨天不持股，今天持股的情况要注意由于只能买卖一次，今天买入就是那唯一一次，前面其实都是0
            dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
        }
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        Leetcode121 leetcode121 = new Leetcode121();
        System.out.println(leetcode121.maxProfit1(new int[]{7, 6, 4, 3, 1}));
    }
}
