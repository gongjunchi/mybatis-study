package org.zuel.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] x = sc.nextLine().split(" ");
            String[] y = sc.nextLine().split(" ");
            int[][] nums = new int[n][2];
            for (int j = 0; j < n; j++) {
                nums[j][0] = Integer.parseInt(x[j]);
                nums[j][1] = Integer.parseInt(y[j]);
            }
            Arrays.sort(nums, (o1, o2) -> {
                return o1[0] - o2[0];
            });
            int res = 1;
//            for (int[] temp : nums) {
//                for (int t : temp) {
//                    System.out.print(t);
//                }
//                System.out.println();
//            }
        }
    }
}