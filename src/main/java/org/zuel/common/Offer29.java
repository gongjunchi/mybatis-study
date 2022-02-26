package org.zuel.common;

public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int l = 0, r = matrix[0].length - 1, t = 0, d = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int k = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[k++] = matrix[t][i];
            }
            if (++t > d) {
                break;
            }
            for (int i = t; i <= d; i++) {
                res[k++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[k++] = matrix[d][i];
            }
            if (--d < t) {
                break;
            }
            for (int i = d; i >= t ; i--) {
                res[k++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer29 offer29 = new Offer29();
        int[] res = offer29.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int re : res) {
            System.out.print(re);
        }
    }
}
