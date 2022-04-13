package org.zuel.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 1) {
            res.add("()");
            return res;
        }
        dfs(n, n, "", res);
        return res;
    }

    public void dfs(int left, int right, String path, ArrayList<String> res) {
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, path.concat("("), res);
        }
        if (right > 0) {
            dfs(left, right - 1, path.concat(")"), res);
        }
    }

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        System.out.println(leetcode22.generateParenthesis(3));
    }
}
