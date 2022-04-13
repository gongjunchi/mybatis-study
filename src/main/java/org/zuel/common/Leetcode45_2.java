package org.zuel.common;

public class Leetcode45_2 {

    // 动态规划
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[len-1] = 0;
        for (int i = len-2; i >= 0; i--) {
            if (nums[i] == 0) {
                // 如果当前点跳不到下一个点，那么这一点跳到最后一点的跳数视为无穷大
                dp[i] = Integer.MAX_VALUE - 1000000;
                continue;
            }
            // 当前点至少可以跳一步，那就索性先让他跳一步，后面有更优情况再覆盖
            dp[i] = dp[i+1] + 1;
            // 当前点可以跳1-k个点
            for (int k = 1; i + k < len && k <= nums[i]; k++) {
                if (i + k == len - 1) {
                    dp[i] = 1;
                    break;
                } else {
                    dp[i] = Math.min(dp[i+k] + 1, dp[i]);
                }
            }
        }
        return dp[0];
    }

    // 贪心
    public int jump1(int[] nums) {
        int n = nums.length;
        // 当前能到达的最远位置
        int maxBounds = 0;
        // 上一步到达的边界
        int end = 0;
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            maxBounds = Math.max(maxBounds, i + nums[i]);
            if (i == end) {
                end = maxBounds;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Leetcode45_2 leetcode45_2 = new Leetcode45_2();
        System.out.println(leetcode45_2.jump1(new int[]{2,3,0,1,4}));
    }
}
