package org.zuel.common;

public class Leetcode167 {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0, right = len - 1;
        int[] res = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode167 leetcode167 = new Leetcode167();
        int[] res = leetcode167.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
