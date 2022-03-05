package org.zuel.common;

public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int res = 0;
        int heapSize = nums.length;
        while (heapSize > 0) {
            swap(nums, 0, --heapSize);
            heapify(nums, 0, heapSize);
            k--;
            if (k == 0) {
                res =  nums[heapSize];
                break;
            }
        }
        return res;
    }

    public void heapInsert(int[] nums, int index) {
        while (index > 0 && nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] nums, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 如果有右子节点，左右子节点比大小取较大的下标
            int large = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            large = nums[index] > nums[large] ? index : large;
            if (large == index) {
                break;
            }
            swap(nums, index, large);
            index = large;
            left = index * 2 + 1;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode215 leetcode215 = new Leetcode215();
        System.out.println(leetcode215.findKthLargest(new int[]{1}, 1));
    }
}
