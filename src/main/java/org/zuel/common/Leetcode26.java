package org.zuel.common;

public class Leetcode26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int start = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == start) {
                continue;
            } else {
                nums[k++] = nums[i];
                start = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Leetcode26 leetcode26 = new Leetcode26();
        System.out.println(leetcode26.removeDuplicates(new int[]{0,0}));
    }
}
