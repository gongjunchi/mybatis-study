package org.zuel.common;

import java.util.Arrays;

public class Leetcode31 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int len = nums.length;
        int i = len - 2, j = len - 1;
        int k = len - 1;
        // 找到一个相邻升序对，如果找到，则从j~end必降序
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        // 如果不是最后一个排列
        if (i >= 0) {
            while (nums[i] >= nums[k]) {
                k--;
            }
            swap(nums, i, k);
        }
        Arrays.sort(nums, j, len);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode31 Leetcode31 = new Leetcode31();
        int[] nums = new int[]{2,3,1};
        Leetcode31.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
