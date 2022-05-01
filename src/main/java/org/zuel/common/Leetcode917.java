package org.zuel.common;

import java.util.Stack;

public class Leetcode917 {

    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'
                    || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'
                    || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sb.append(stack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String reverseOnlyLetters1(String s) {
        int i = 0, j = s.length() - 1;
        char[] chs = s.toCharArray();
        while (i < j) {
            while (i < s.length() && !Character.isLetter(chs[i])) {
                i++;
            }
            while (j >= 0 && !Character.isLetter(chs[j])) {
                j--;
            }
            if (i < j) {
                swap(chs, i, j);
                i++;
                j--;
            }
        }
        return String.valueOf(chs);
    }

    public void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode917 leetcode917 = new Leetcode917();
        System.out.println(leetcode917.reverseOnlyLetters1("7_28]"));
    }
}
