package org.zuel.common;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {

    public int findMinArrowShots(int[][] points) {
        // 应该注意到不需要两个数都排序，只需要按区间上限排序
        int m = points.length;
        long[][] temp = new long[m][2];
        for (int i = 0; i < m; i++) {
            temp[i][0] = points[i][0];
            temp[i][1] = points[i][1];
        }
        Arrays.sort(temp, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            } else {
                return Long.compare(o1[0], o2[0]);
            }
        });
        int res = 0;
        int i = 0, j = 0;
        while (i < m) {
            long end = temp[i][1];
            j = i + 1;
            while (j < m) {
                if (temp[j][0] <= end) {
                    end = Math.min(end, temp[j][1]);
                    j++;
                } else {
                    break;
                }
            }
            res += 1;
            i = j;
        }
        return res;
    }

    public int findMinArrowShots1(int[][] points) {
        // 应该注意到不需要两个数都排序，只需要按区间上限排序
        int m = points.length;

        // 排序过程重可以避免正负数相减超出int型边界的情况
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int res = 1;
        int end = points[0][1];
        for (int i = 1; i < m; i++) {
            if (points[i][0] > end) {
                res += 1;
                end = points[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode452 leetcode452 = new Leetcode452();
        System.out.println(leetcode452.findMinArrowShots1(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
