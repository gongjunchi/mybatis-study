package org.zuel.common;

/**
 * 字符串的综合操作
 */
public class Leetcode151 {

    public String reverseWords(String s) {
        // 1.去除空格
        StringBuilder sb = new StringBuilder(s);
        StringBuilder builder = removeSpace(sb);
        // 2.反转字符串
        reverseString(builder, 0, builder.length() - 1);
        // 3.反转每个单词
        reverseEachWord(builder);
        return builder.toString();
    }

    public StringBuilder removeSpace(StringBuilder sb) {
        // 去除两边的空格
        int left = 0, right = sb.length() - 1;
        while (sb.charAt(left) == ' ') {
            left++;
        }
        while (sb.charAt(right) == ' ') {
            right--;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = left; i <= right; i++) {
            if (sb.charAt(i) == ' ' && sb.charAt(i - 1) == ' ') {
                continue;
            }
            builder.append(sb.charAt(i));
        }
        return builder;
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 0;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    public static void main(String[] args) {
        Leetcode151 leetcode151 = new Leetcode151();
        System.out.println(leetcode151.reverseWords("  hello   world!  "));
    }
}
