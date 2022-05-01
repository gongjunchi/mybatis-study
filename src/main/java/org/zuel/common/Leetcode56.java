package org.zuel.common;

import java.util.*;

public class Leetcode56 {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int[] interval : intervals) {
            if (interval[0] <= res.get(res.size() - 1)[1]) {
                res.get(res.size() - 1)[1] = Math.max(interval[1], res.get(res.size() - 1)[1]);
            } else {
                res.add(interval);
            }
        }
        int[][] temp = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            temp[i] = res.get(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        Leetcode56 leetcode56 = new Leetcode56();
        int[][] res = leetcode56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] t : res) {
            for (int num : t) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
