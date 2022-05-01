package org.zuel;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 数字个数
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        System.out.println(maxSum);
    }
}
