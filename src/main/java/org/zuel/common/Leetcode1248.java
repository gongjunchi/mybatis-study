package org.zuel.common;

import java.util.HashMap;

public class Leetcode1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        // 做一个hashmap存前缀奇数数字个数
        HashMap<Integer, Integer> preOddMap = new HashMap<>();
        preOddMap.put(0, 1);
        int preOdd = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                preOdd += 1;
            }
            // preOdd - (preOdd - k) = k
            if (preOddMap.containsKey(preOdd - k)) {
                count += preOddMap.get(preOdd - k);
            }
            preOddMap.put(preOdd, preOddMap.getOrDefault(preOdd, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode1248 leetcode1248 = new Leetcode1248();
        System.out.println(leetcode1248.numberOfSubarrays(new int[]{1,1,1,1,1}, 2));
    }
}
