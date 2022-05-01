package org.zuel.common;

public class Leetcode343 {

    public int integerBreak(int n) {
        int res = 1;
        if (n == 4) {
            return 4;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 2) {
            return 1;
        }
        while (n >= 5) {
            n -= 3;
            res *= 3;
        }
        res *= n;
        return res;
    }

    public static void main(String[] args) {
        Leetcode343 leetcode343 = new Leetcode343();
        System.out.println(leetcode343.integerBreak(12));
    }
}
