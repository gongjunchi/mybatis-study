package org.zuel.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode46 {

    List<List<Integer>> res = new LinkedList<>();;
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, visited);
        return res;
    }

    // 回溯
    public void dfs(int[] nums, int depth, boolean[] visited) {
        // 全排列的问题要控制深度了，只有到达最大深度的时候才会往最终结果集中添加
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 注意这里的i起始是0，因为已经用了visited控制是否用过，每次都可以从头开始
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, depth+1, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode46 leetcode46 = new Leetcode46();
        List<List<Integer>> res = leetcode46.permute(new int[]{1,2,3});
        res.forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
