package org.zuel.common;

public class Leetcode5 {

    // 中心扩散法
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            int l = i - 1, r = i + 1;
            // 先向左移动，找与当前字符相同的字符
            while (l >= 0 && s.charAt(i) == s.charAt(l)) {
                l--;
                len++;
            }
            while (r < s.length() && s.charAt(i) == s.charAt(r)) {
                r++;
                len++;
            }
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                len += 2;
                l--;
                r++;
            }
            if (len > maxLen) {
                start = l;
                maxLen = len;
            }
        }
        return s.substring(start + 1, start + 1 + maxLen);
    }

    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.longestPalindrome("a"));
    }
}
