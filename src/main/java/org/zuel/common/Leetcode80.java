package org.zuel.common;

public class Leetcode80 {

    public int removeDuplicates(int[] nums) {
        int start = nums[0];
        int k = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == start && count < 2) {
                count++;
                nums[k++] = nums[i];
            } else if (nums[i] != start) {
                nums[k++] = nums[i];
                count = 1;
                start = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Leetcode80 leetcode80 = new Leetcode80();
        System.out.println(leetcode80.removeDuplicates(new int[]{0,0,1, 1, 1,1,2, 3, 3}));
    }
}
