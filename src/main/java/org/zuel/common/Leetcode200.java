package org.zuel.common;

public class Leetcode200 {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 如果当前格子是陆地，开始遍历，将与之相连的陆地全换成另一种形态，表示这是一片连着的陆地
                    dfs(grid, i, j);
                    res += 1;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        // 越界终止
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        // 如果当前格子不是陆地，终止
        if (grid[i][j] != '1') {
            return;
        }
        // 将当前格标记为已遍历
        grid[i][j] = '2';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
