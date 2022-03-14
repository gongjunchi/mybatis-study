package org.zuel.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode40 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target);
        return res;
    }

    public void dfs(int cur, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            if (i > cur && candidates[i] == candidates[i - 1]) {
                i++;
            }
            temp.add(candidates[i]);
            System.out.println("递归之前 => " + temp + "，剩余 = " + (target - candidates[i]));
            dfs(i + 1, candidates, target - candidates[i]);
            temp.remove(temp.size() - 1);
            System.out.println("递归之后 => " + temp + "，剩余 = " + (target));
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
