package org.zuel.common;

public class Leetcode213 {

    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if (nums.length < 2) {
            return nums[0];
        }
        // 偷第一间
        dp[0] = nums[0];
        for (int i = 1; i < len - 1; i++) {
            if (i < 2) {
                dp[i] = Math.max(dp[i-1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        // 不偷第一间
        int[] res = new int[len + 1];
        res[1] = nums[1];
        for (int i = 2; i < len; i++) {
            if (i < 3) {
                res[i] = Math.max(res[i-1], nums[i]);
            } else {
                res[i] = Math.max(res[i-1], res[i-2] + nums[i]);
            }
        }
        return Math.max(dp[len - 2], res[len - 1]);
    }

    public static void main(String[] args) {
        Leetcode213 leetcode213 = new Leetcode213();
        System.out.println(leetcode213.rob(new int[]{1,2,3}));
    }
}
