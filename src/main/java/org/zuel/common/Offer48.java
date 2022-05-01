package org.zuel.common;

import java.util.ArrayList;
import java.util.HashMap;

public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = 0, right = 0;
        int res = 0;
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        while (right < len - 1) {
            map.put(s.charAt(right), right);
            right += 1;
            if (map.containsKey(s.charAt(right))) {
                index = Math.max(index, map.get(s.charAt(right)));
                left = index + 1;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Offer48 offer48 = new Offer48();
        System.out.println(offer48.lengthOfLongestSubstring("abba"));
    }
}
