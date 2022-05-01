package org.zuel.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 如果第一个值就已经大于0了，因为已经排过序，后面的数肯定更大，不可能得到和为0的组合
                return res;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    // 去重，针对[-2,0,0,2,2]的情况
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode15 leetcode15 = new Leetcode15();
        List<List<Integer>> lists = leetcode15.threeSum(new int[]{1,-1,-1,0});
        lists.forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
