package org.zuel.sort;

import java.util.Collections;
import java.util.Random;

public class QuickSort {

    private static Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        // 用随机数可以优化排序
        int randomIndex = random.nextInt(r - l + 1) + l;
        swap(nums, randomIndex, l);
        int i = l, j = r;
        int temp = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }
            while (i < j && nums[i] <= temp) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, l, i);
        quickSort(nums, l, i-1);
        quickSort(nums, i+1, r);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{4,2,5,3,1,6,7,3,3,3};
        quickSort.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
