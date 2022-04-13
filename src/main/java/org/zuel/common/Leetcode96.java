package org.zuel.common;

public class Leetcode96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 先决条件：只要节点个数相同，方案数就相同
        // 一共几个节点
        for (int i = 2; i <= n; i++) {
            // 左边几个节点
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode96 leetcode96 = new Leetcode96();
        System.out.println(leetcode96.numTrees(3));
    }
}
