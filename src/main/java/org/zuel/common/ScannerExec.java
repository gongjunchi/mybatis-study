package org.zuel.common;

import java.util.*;

public class ScannerExec {

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
        int[] nums = new int[]{4,3,2,1};
        Arrays.sort(nums, 1, nums.length);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
