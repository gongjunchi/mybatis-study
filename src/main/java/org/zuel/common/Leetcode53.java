package org.zuel.common;

public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        System.out.println(leetcode53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
