package org.zuel.common;

import java.util.*;

public class ScannerExec {

    List<List<Integer>> res = new LinkedList<>();;
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    // 回溯
    public void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 注意这里必须是i>start，否则第一次满足条件的树也将被剪掉
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        ScannerExec exec = new ScannerExec();
//        List<List<Integer>> res = exec.subsets(new int[]{1, 2, 2});
//        res.forEach(list -> {
//            System.out.println(list.toString());
//        });
    }
}
