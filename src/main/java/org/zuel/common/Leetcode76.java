package org.zuel.common;

public class Leetcode76 {

    public String minWindow(String s, String t) {
        // 创建数组用来存需要哪些字符
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            // 初始化need数组
            need[t.charAt(i)]++;
        }
        // 最后通过窗口起点start和窗口大小size，返回最终结果
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        // 当窗口有边界超过s的右边界时，退出循环
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {
                // 说明t中包含该字符，即需要该字符
                count--;
            }
            need[c]--;
            if (count == 0) {
                // 如果窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    // 窗口要右移，最左边的元素需求量+1
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    // 窗口不能右移时，与当前最优解进行比较，保留更优解
                    size = r - l + 1;
                    start = l;
                }
                // 窗口继续右移，此时一定不满足条件了
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
