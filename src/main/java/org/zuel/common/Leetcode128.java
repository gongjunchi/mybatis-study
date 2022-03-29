package org.zuel.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 达到去重的效果且将查找数组是否含有某个元素的复杂度降到o(1)
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            // 假如x到y是最长子序列，那么x在数组中一定不存在前驱数x-1，因为否则x-1到y是最长序列
            // 因此可以判断如果x在数组中有前驱数，直接continue，因为一定有子序列比以它为开头的子序列长
            if (!set.contains(num - 1)) {
                // 如果数组中不存在前驱数，才有继续下去的必要
                int curNum = num;
                int curLength = 1;
                // 这一层循环最多顺着当前数遍历数组的剩下所有元素，不会重新遍历整个数组，不为提高时间复杂度
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLength += 1;
                }
                res = Math.max(res, curLength);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode128 leetcode128 = new Leetcode128();
        System.out.println(leetcode128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
