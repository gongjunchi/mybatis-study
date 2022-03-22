package org.zuel.common;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 2, 3},{4, 1, 2}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
