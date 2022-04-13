package org.zuel.common;

public class Leetcode91 {

    public int numDecodings(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {

            int a = s.charAt(i) - '0', b = (s.charAt(i-1) - '0')*10 + s.charAt(i) - '0';
            // 如果可以自己成数
            if (a >= 1 && a <= 9) {
                dp[i] += dp[i-1];
            }
            if (b >= 10 && b <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i-2];
                }
            }

        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        Leetcode91 leetcode91 = new Leetcode91();
        System.out.println(leetcode91.numDecodings("17"));
    }
}
