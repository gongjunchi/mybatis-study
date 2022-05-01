package org.zuel.common;

import java.math.BigInteger;

public class Leetcode633 {

    public boolean judgeSquareSum(int c) {
        long max = (long) Math.sqrt(c);
        long i = 0;
        while (i <= max) {
            long sum = (i * i) + (max * max);
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                max--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode633 leetcode633 = new Leetcode633();
        System.out.println(leetcode633.judgeSquareSum(2147483600));
    }
}
