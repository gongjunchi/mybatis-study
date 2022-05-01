package org.zuel.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j;
            // 从i位置开始向前遍历元素，如果前面的元素更大，依次向后挪一位，空出temp应该在的位置
            for (j = i; j > 0; j--) {
                if (nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
            nums[j] = temp;
        }
        return nums;
    }
}
