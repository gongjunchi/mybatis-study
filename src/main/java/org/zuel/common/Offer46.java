package org.zuel.common;

public class Offer46 {

    public int translateNum(int num) {
        char[] chs = String.valueOf(num).toCharArray();
        int len = chs.length;
        if (len <= 1) {
            return 1;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = (chs[0] <= '2' && chs[1] <= '5') || (chs[0] == '1') ? 2 : 1;
        for (int i = 2; i < len; i++) {
            dp[i] += dp[i-1];
            if (chs[i] <= '5' && chs[i - 1] > '0' && chs[i - 1] <= '2') {
                dp[i] += dp[i-2];
            } else if (chs[i - 1] == '1') {
                dp[i] += dp[i-2];
            }
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        Offer46 offer46 = new Offer46();
        System.out.println(offer46.translateNum(18580));
    }
}
