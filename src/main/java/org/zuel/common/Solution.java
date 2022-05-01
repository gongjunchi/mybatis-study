package org.zuel.common;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.util.*;

public class Solution {

    public int solution(String[] R) {
        // write your code in Java SE 8
        int n = R.length, m = R[0].length();
        boolean[][] visited = new boolean[n][m];
        boolean[][][] pos = new boolean[n][m][4];
        int res = 0;
        int direct = 0;
        int i = 0, j = 0;
        while (true) {
            while (i >= 0 && j >= 0 && i < n && j < m && R[i].charAt(j) == '.') {
                if (pos[i][j][direct]) {
                    return res;
                }
                pos[i][j][direct] = true;
                if (!visited[i][j]) {
                    res += 1;
                    visited[i][j] = true;
                }
                if (direct == 0) {
                    j++;
                } else if (direct == 1) {
                    i++;
                } else if (direct == 2) {
                    j--;
                } else {
                    i--;
                }
            }
            if (direct == 0) {
                j--;
            } else if (direct == 1) {
                i--;
            } else if (direct == 2) {
                j++;
            } else {
                i++;
            }
            direct = (direct + 1) % 4;
        }
    }
}
