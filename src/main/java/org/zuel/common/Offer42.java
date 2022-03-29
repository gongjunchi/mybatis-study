package org.zuel.common;

public class Offer42 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-1], 0);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        Offer42 offer42 = new Offer42();
        System.out.println(offer42.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
