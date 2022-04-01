package org.zuel.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode90 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }

    // [1,2,2]
    public void dfs(int start, int[] nums) {
        res.add(new ArrayList<>(tmp));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            /*去重的重要步骤 保留第一次的相同值 跳过同一层的相同值*/
            // 注意这里必须是i>start，否则第一次满足条件的树也将被剪掉
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            tmp.add(nums[i]);
            dfs(i + 1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode90 leetcode90 = new Leetcode90();
        List<List<Integer>> res = leetcode90.subsetsWithDup(new int[]{1,2,2});
        res.forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
