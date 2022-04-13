package org.zuel.common;

public class Leetcode97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length();
        if (s3.length() != n1 + n2) {
            return false;
        }
        // dp[i][j]的含义是s1前i个字符和s2的前j个字符能否拼成s3的前i+j个字符
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n2 && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 注意i+j-1
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
                        || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Leetcode97 leetcode97 = new Leetcode97();
        System.out.println(leetcode97.isInterleave("a", "b", ""));
    }
}
