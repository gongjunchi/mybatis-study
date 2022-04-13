package org.zuel.common;

public class Leetcode72 {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        // 两个字符串都可能为空，用下标0,0表示此情形
        // 题目关键就在于理解dp数组的含义，dp[i][j]表示将word1的前i个字符改成和word2前j个字符一致的最少操作数
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        // 第一行，此时word1是空，变成word2就是执行插入操作
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i-1] + 1;
        }
        // 第一列
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Leetcode72 leetcode72 = new Leetcode72();
        System.out.println(leetcode72.minDistance("horse", "ros"));
    }
}
