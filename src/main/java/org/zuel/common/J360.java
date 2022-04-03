package org.zuel.common;

import java.util.Scanner;

public class J360 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 占据榜首天数
        int n = sc.nextInt();
        // 其他粉丝数量
        int m = sc.nextInt();
        int[][] value = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                value[i][j] = sc.nextInt();
            }
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        int[] sum = new int[m];
        int[] max = new int[n];
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            int every = 0;
            for (int j = 0; j < m; j++) {
                sum[j] += value[i-1][j];
                temp = Math.max(sum[j], temp);
                every = Math.max(value[i-1][j], every);
            }
            if (i <= 7) {
                dp[i] = temp + 1;
                continue;
            }
            else {
                dp[i] = dp[i-1] + every + 1;
            }
        }
        System.out.println(dp[n]);
    }
}
