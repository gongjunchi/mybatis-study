package org.zuel.common;

import java.util.HashMap;

public class Leetcode983 {
    public int mincostTickets(int[] days, int[] costs) {
        // 先获取最大出行天和最小出行天和需要出行的天数
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        // 创建dp数组，多加几天防止后面d+30越界
        int[] dp = new int[maxDay + 31];
        // i表示数组的下标，d表示每天
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            if (d == days[i]) {
                // 只有当d是需要出行的日子时才考虑买票
                // 3种方案进行对比
                dp[d] = Math.min(costs[0] + dp[d + 1], costs[1] + dp[d + 7]);
                dp[d] = Math.min(dp[d], costs[2] + dp[d + 30]);
                i--;
            } else {
                // 如果当天不出门，当天开销与d+1天一致
                dp[d] = dp[d + 1];
            }
        }
        return dp[minDay];
    }

    public static void main(String[] args) {
        Leetcode983 leetcode983 = new Leetcode983();
        System.out.println(leetcode983.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }
}
