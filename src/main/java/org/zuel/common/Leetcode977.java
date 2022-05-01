package org.zuel.common;

public class Leetcode977 {

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int left = 0, right = len - 1;
        int k = len - 1;
        while (left <= right) {
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                res[k--] = nums[right] * nums[right];
                right--;
            } else {
                res[k--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode977 leetcode977 = new Leetcode977();
        int[] res = leetcode977.sortedSquares(new int[]{-4, -2, -1});
        for (int num : res) {
            System.out.print(num);
            System.out.print(' ');
        }
    }
}
