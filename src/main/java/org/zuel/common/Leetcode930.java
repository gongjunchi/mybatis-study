package org.zuel.common;

import java.util.HashMap;

public class Leetcode930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        for (int i = 0; i < len; i++) {
            preSum += nums[i];

            if (map.containsKey(preSum - goal)) {
                res += map.get(preSum - goal);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }
        return res;

    }

    public static void main(String[] args) {
        Leetcode930 leetcode930 = new Leetcode930();
        System.out.println(leetcode930.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
