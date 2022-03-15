package org.zuel.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode47 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        // 剪枝往往需要先排序
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }

    public void dfs(int depth, int[] nums) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(depth + 1, nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode47 leetcode47 = new Leetcode47();
        List<List<Integer>> res = leetcode47.permuteUnique(new int[]{1,1,2});
        res.forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
