package org.zuel.common;

public class Offer12 {

    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != words[k] || visited[i][j]) {
            // 出现这些情况说明当前分支不满足条件，直接返回
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        //board[i][j] = '\0';
        visited[i][j] = true;
        boolean temp =  dfs(board, words, i-1, j, k + 1) || dfs(board, words, i+1, j, k + 1)
                || dfs(board, words, i, j-1, k + 1) || dfs(board, words, i, j+1, k + 1);
        //board[i][j] = words[k];
        visited[i][j] = false;
        return temp;
    }

    public static void main(String[] args) {
        Offer12 offer12 = new Offer12();
        System.out.println(offer12.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}}, "ABCCED"));
    }
}
