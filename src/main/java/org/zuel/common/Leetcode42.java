package org.zuel.common;

import java.util.PriorityQueue;

public class Leetcode42 {

    public int trap(int[] height) {
        int res = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            int maxLeft = 0;
            for (int j = i-1; j >= 0; j--) {
                if (height[j] > height[maxLeft]) {
                    maxLeft = j;
                }
            }
            int maxRight = i;
            for (int j = i+1; j < len; j++) {
                if (height[j] > height[maxRight]) {
                    maxRight = j;
                }
            }
            // 对于一个柱子，能不能装水，能装多少是由左右最高柱子中较小的那个决定
            int higher = Math.min(height[maxLeft], height[maxRight]);
            if (higher > height[i]) {
                res += higher - height[i];
            }
        }
        return res;
    }

    // 方法1中每次都要往两边找左右的最大值，可以用动态规划，将这些中间结果缓存起来
    public int trap1(int[] height) {
        int res = 0;
        int len = height.length;
        // 保存当前元素左边最大值
        int[] maxLeft = new int[len];
        for (int i = 1; i < len; i++) {
            if (height[i-1] > maxLeft[i-1]) {
                maxLeft[i] = height[i-1];
            } else {
                maxLeft[i] = maxLeft[i-1];
            }
        }
        // 保存当前元素右边最大值下标
        int[] maxRight = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            if (height[i+1] > maxRight[i+1]) {
                maxRight[i] = height[i+1];
            } else {
                maxRight[i] = maxRight[i+1];
            }
        }
        for (int i = 0; i < len; i++) {
            // 对于一个柱子，能不能装水，能装多少是由左右最高柱子中较小的那个决定
            int higher = Math.min(maxLeft[i], maxRight[i]);
            if (higher > height[i]) {
                res += higher - height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode42 leetcode42 = new Leetcode42();
        System.out.println(leetcode42.trap1(new int[]{4,2,0,3,2,5}));
    }
}
