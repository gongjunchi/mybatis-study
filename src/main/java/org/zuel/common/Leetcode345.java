package org.zuel.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Leetcode345 {

    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        while (i < j) {
            while (i < j && !set.contains(Character.toLowerCase(chs[i]))) {
                i++;
            }
            while (i < j && !set.contains(Character.toLowerCase(chs[j]))) {
                j--;
            }
            swap(chs, i, j);
            i++;
            j--;
        }
        return String.valueOf(chs);
    }

    public void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode345 leetcode345 = new Leetcode345();
        System.out.println(leetcode345.reverseVowels("hello"));
    }
}
