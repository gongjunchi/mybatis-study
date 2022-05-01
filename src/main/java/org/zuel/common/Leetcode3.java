package org.zuel.common;

import java.util.HashMap;

/**
 * 本题和剑指Offer48相同
 */
public class Leetcode3 {

    // 双指针加map
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (left < len && right < len - 1) {
            map.put(s.charAt(right), right);
            right += 1;
            // 发现重复字符，要移动左指针
            if (map.containsKey(s.charAt(right))) {
                // 找到重复字符上次出现的位置，要和原先的left比较大小取较大的，针对abba的情况
                // 当left=2，right=3时，a已存在，直接取下标为0再加1等于1，而left现在在2位置，不能倒退回去
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    // 滑动窗口


    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        System.out.println(leetcode3.lengthOfLongestSubstring("tmmzuxt"));
    }
}
