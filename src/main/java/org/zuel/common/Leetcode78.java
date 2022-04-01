package org.zuel.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode78 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs1(0, nums);
        return res;
    }

    public void dfs(int cur, int[] nums) {
        // 数组遍历完毕，加入最终结果
        if (cur == nums.length) {
            // 要复制一份tmp
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[cur]);
        dfs(cur + 1, nums);
        tmp.remove(tmp.size() - 1);
        dfs(cur + 1, nums);
    }

    public void dfs1(int cur, int[] nums) {
        res.add(new ArrayList<>(tmp));
        // 可以不加判断
        if (cur == nums.length) {
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs1(i + 1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode78 leetcode78 = new Leetcode78();
        List<List<Integer>> res = leetcode78.subsets(new int[]{1,2,3});
        res.forEach(list -> {
            System.out.println(list.toString());
        });
    }
}
