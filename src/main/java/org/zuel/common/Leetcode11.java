package org.zuel.common;

public class Leetcode11 {

    public int maxArea(int[] height) {
        int res = 0;
        int len = height.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                // 此时移动右边的柱子是无效的情况，因为左边决定了高最多是height[left]，移动右柱子只会让宽减小
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode11 leetcode11 = new Leetcode11();
        System.out.println(leetcode11.maxArea(new int[]{1,1}));
    }
}
