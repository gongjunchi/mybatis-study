package org.zuel.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yanghui {

    public ArrayList<ArrayList<Integer>> generate (int numRows) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        int[][] dp = new int[numRows][numRows];
//        dp[0][0] = 1;
//        for (int i = 1; i < numRows; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i < numRows; i++) {
//            for (int j = 1; j < numRows; j++) {
//                if (i == j) {
//                    dp[i][j] = 1;
//                } else {
//                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
//                }
//            }
//        }
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    temp.add(1);
                } else if (i == j) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        Yanghui yanghui = new Yanghui();
        ArrayList<ArrayList<Integer>> res = yanghui.generate(4);
        res.forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
