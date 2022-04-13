package org.zuel.common;

public class Leetcode152 {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[][] dp = new int[len][2];
        // 第二维为0表示下标为i的最大值，1表示下标为i的最小值
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.min(dp[i-1][0] * nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i-1][1] * nums[i], nums[i]);
            } else {
                dp[i][0] = Math.min(dp[i-1][1] * nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i-1][0] * nums[i], nums[i]);
            }
            res = Math.max(dp[i][1], res);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode152 leetcode152 = new Leetcode152();
        System.out.println(leetcode152.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
