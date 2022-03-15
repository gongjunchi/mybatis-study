package org.zuel.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode46 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        int depth = nums.length;
        dfs(0, nums);
        return res;
    }

    public void dfs(int depth, int[] nums) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(depth + 1, nums);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
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
