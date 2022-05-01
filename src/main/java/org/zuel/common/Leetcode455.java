package org.zuel.common;

import java.util.Arrays;

public class Leetcode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int res = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                res += 1;
                i++;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode455 leetcode455 = new Leetcode455();
        System.out.println(leetcode455.findContentChildren(new int[]{7,8,9,10}, new int[]{5,6,7,8}));
    }
}
