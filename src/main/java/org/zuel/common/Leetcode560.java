package org.zuel.common;

import java.util.HashMap;

public class Leetcode560 {

    public int subarraySum(int[] nums, int k) {
        // map维护的是前缀和
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        // 下标为0的元素前面没有其它元素了，前缀和为0，个数为1
        preSumMap.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            // preSum - (preSum - k) = k，因此在计算包含当前数的前缀和之后可以查map里面有多少个前缀和等于preSum - k
            if (preSumMap.containsKey(preSum - k)) {
                count += preSumMap.get(preSum - k);
            }
            // 维护map
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
