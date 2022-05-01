package org.zuel.common;

import java.util.Arrays;

public class Leetcode16 {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                res = Math.abs(sum - target) < Math.abs(res - target) ? sum : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode16 leetcode16 = new Leetcode16();
        System.out.println(leetcode16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
