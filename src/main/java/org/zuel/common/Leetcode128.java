package org.zuel.common;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode128 {

    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            // 这里保存到变量cur中为了不修改循环变量
            int cur = num;
            if (!set.contains(cur - 1)) {
                // 集合中不包含比当前值小的值，说明当前值有作为序列起始值的可能
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            res = Math.max(res, cur - num + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode128 leetcode128 = new Leetcode128();
        System.out.println(leetcode128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
