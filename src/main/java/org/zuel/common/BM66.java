package org.zuel.common;

public class BM66 {

    public String LCS (String str1, String str2) {
        // write code here
        int maxLength = 0;
        // 最长子串最后一个元素在str1中的下标
        int maxEnd = 0;
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if (dp[i+1][j+1] > maxLength) {
                        maxLength = dp[i+1][j+1];
                        maxEnd = i;
                    }
                } else {
                    dp[i+1][j+1] = 0;
                }
            }
        }
        return str1.substring(maxEnd + 1 - maxLength, maxEnd + 1);
    }

    public static void main(String[] args) {
        BM66 bm66 = new BM66();
        System.out.println(bm66.LCS("1", "12345EF"));
    }
}
