package org.zuel.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode39 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序后可以剪枝
        Arrays.sort(candidates);
        dfs(0, candidates, target);
        return res;
    }

    public void dfs(int begin, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 剪枝，如果再往下一层会造成target小于0，这一支不符合条件，直接剪掉
            if (target - candidates[i] < 0) {
                break;
            }
            temp.add(candidates[i]);
            dfs(i, candidates, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode39 leetcode39 = new Leetcode39();
        List<List<Integer>> res = leetcode39.combinationSum(new int[]{2,3,6,7}, 7);
        res.forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
