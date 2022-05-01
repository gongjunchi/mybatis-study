package org.zuel.sort;

/**
 * 选择排序
 * 用力扣912题验证结果
 */
public class SelectSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            // 从i~len-1范围内选最小，放在i位置
            for (int j = i; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] nums = new int[]{4,2,5,3,1,4,7,3,3,3};
        int[] res = selectSort.sortArray(nums);
        for (int num : res) {
            System.out.print(num);
        }
    }
}
