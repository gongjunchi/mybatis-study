package org.zuel.common;

public class Leetcode704 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode704 leetcode704 = new Leetcode704();
        System.out.println(leetcode704.search(new int[]{5}, 5));
    }
}
