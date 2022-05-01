package org.zuel.common;

public class Leetcode344 {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode344 leetcode344 = new Leetcode344();
        char[] chs = new char[]{'h', 'e', 'l', 'l', 'o'};
        leetcode344.reverseString(chs);
        for (char ch : chs) {
            System.out.print(ch);
        }
    }
}
