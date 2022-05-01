package org.zuel.common;

import java.util.Stack;

public class Leetcode20 {

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode20 leetcode20 = new Leetcode20();
        System.out.println(leetcode20.isValid("{[[}]}"));
    }
}
