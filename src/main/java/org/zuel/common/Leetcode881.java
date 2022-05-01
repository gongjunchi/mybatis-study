package org.zuel.common;

import java.util.Arrays;

public class Leetcode881 {

    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        int left = 0, right = len - 1;
        int res = 0;
        int sum = 0;
        Arrays.sort(people);
        // left == right的时候只有一个人尚未分配，直接给一艘船就行了
        while (left <= right) {
            sum = people[left] + people[right];
            if (sum <= limit) {
                res += 1;
                left++;
                right--;
            } else {
                res += 1;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode881 leetcode881 = new Leetcode881();
        System.out.println(leetcode881.numRescueBoats(new int[]{3,2,2,1}, 3));
    }
}
