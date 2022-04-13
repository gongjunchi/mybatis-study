package org.zuel.common;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExec {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 2, 3},{2, 1, 2}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.printf("%.2f", 1.2345);
    }
}
