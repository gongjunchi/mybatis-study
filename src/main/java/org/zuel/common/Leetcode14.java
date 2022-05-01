package org.zuel.common;

public class Leetcode14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        char ch;
        while (true) {
            if (i >= strs[0].length()) {
                return sb.toString();
            } else {
                ch = strs[0].charAt(i);
            }
            for (String str : strs) {
                if (i >= str.length() || str.charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
            i++;
        }
    }

    public static void main(String[] args) {
        Leetcode14 leetcode14 = new Leetcode14();
        System.out.println(leetcode14.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
