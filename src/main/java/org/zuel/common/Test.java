package org.zuel.common;

import java.util.HashMap;

public class Test {

    public int subarraySum(int[] nums, int k) {
        // 用map保存前缀和为key的有多少种
        HashMap<Integer, Integer> map = new HashMap<>();
        // 前缀和为0的有一种，就是什么都不取
        map.put(0, 1);
        int preSum = 0;
        int res = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.subarraySum(new int[]{1,2,3}, 2));
    }
}
