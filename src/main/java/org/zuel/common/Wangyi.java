package org.zuel.common;

import java.util.Scanner;

public class Wangyi {

    public static void dianyingyuan(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        // 两个1之间的最大长度
        int maxLen1 = 0;
        int i = 0, j = nums.length - 1;
        while (i < nums.length) {
            if (nums[i] == 0) {
                i++;
            } else {
                break;
            }
        }
        // 上一个1下标
        int last1 = i;
        while (j >= 0) {
            if (nums[j] == 0) {
                j--;
            } else {
                break;
            }
        }
        for (int k = i; k <= j; k++) {
            if (nums[k] == 1) {
                maxLen1 = Math.max(k - last1, maxLen1);
                last1 = k;
            }
        }
        System.out.println(Math.max(Math.max(i, maxLen1 / 2), nums.length - 1 - j));
    }

    public static void jiemi() {
        //        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        if (str.length() < 2) {
//            System.out.println(1);
//            return;
//        }
//        int[] dp = new int[str.length() + 1];
//        HashSet<String> set = new HashSet<>();
//        set.add("0");
//        set.add("1");
//        set.add("10");
//        set.add("11");
//        set.add("100");
//        set.add("101");
//        set.add("110");
//        set.add("111");
//        dp[0] = 1;
//        dp[1] = 1;
//        dp[2] = str.charAt(0) == '0' ? 1 : 2;
//        for (int i = 3; i <= str.length(); i++) {
//            // 单独i
//            dp[i] = dp[i - 1];
//            // 如果i能和i-1组成一组
//            if (set.contains(str.substring(i - 2, i))) {
//                dp[i] += dp[i - 2];
//            }
//            // 如果i能和i-1,i-2组成一组
//            if (set.contains(str.substring(i - 3, i))) {
//                dp[i] += dp[i - 3];
//            }
//        }
//        System.out.println(dp[str.length()]);
//
//
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        if (chs.length < 2) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[chs.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = chs[0] == '0' ? 1 : 2;
        for (int i = 3; i <= chs.length; i++) {
            dp[i] = dp[i - 1];
            if (chs[i - 2] != '0') {
                dp[i] += dp[i - 2];
            }
            if (chs[i - 3] != '0') {
                dp[i] += dp[i - 3];
            }
        }
        System.out.println(dp[chs.length]);
    }
}
