package org.zuel.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i == j) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                    break;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }
        Arrays.sort(dp[m-1]);
        return dp[m-1][0];
    }

    public static void main(String[] args) {
        Leetcode120 leetcode120 = new Leetcode120();
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> layer1 = new ArrayList<>();
        layer1.add(2);
        ArrayList<Integer> layer2 = new ArrayList<>();
        layer2.add(3);
        layer2.add(4);
        ArrayList<Integer> layer3 = new ArrayList<>();
        layer3.add(6);
        layer3.add(5);
        layer3.add(7);
        ArrayList<Integer> layer4 = new ArrayList<>();
        layer4.add(4);
        layer4.add(1);
        layer4.add(8);
        layer4.add(3);
        triangle.add(layer1);
        triangle.add(layer2);
        triangle.add(layer3);
        triangle.add(layer4);
        System.out.println(leetcode120.minimumTotal(triangle));
    }
}
