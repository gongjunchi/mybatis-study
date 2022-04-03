package org.zuel.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode40 {

    List<List<Integer>> res = new LinkedList<>();;
    List<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    // 回溯
    public void dfs(int[] nums, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (target < nums[i]) {
                continue;
            }
//            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
//                continue;
//            }
            // 另一种写法，同一层，如果同一个元素已经用过了，就不能再用
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, i + 1, target - nums[i]);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode40 leetcode40 = new Leetcode40();
        List<List<Integer>> res = leetcode40.combinationSum2(new int[]{2,5,2,1,2}, 5);
        res.forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
