package org.zuel.common;

public class Leetcode149 {

    public int maxPoints(int[][] points) {
        int len = points.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int[] a = points[i];
            for (int j = i + 1; j < len; j++) {
                int[] b = points[j];
                int count = 2;
                for (int k = j + 1; k < len; k++) {
                    int[] c = points[k];
                    // 为了避免精度问题，不计算斜率，通过乘法运算判断斜率是否相同
                    int c1 = (b[1] - a[1]) * (c[0] - a[0]);
                    int c2 = (b[0] - a[0]) * (c[1] - a[1]);
                    if (c1 == c2) {
                        count++;
                    }
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode149 leetcode149 = new Leetcode149();
        System.out.println(leetcode149.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }
}
