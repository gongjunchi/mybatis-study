package org.zuel.common;

public class Leetcode27 {

    // 相向双指针，此方法改变了元素的相对位置，确保了移动最少元素
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // left指向第一个要删除的数字，right指向第一个不用删除的数字，交换
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < right && nums[right] == val) {
                right--;
            }
            while (left < right && nums[left] != val) {
                left++;
            }
            swap(nums, left, right);
        }
        return nums[left] == val ? left : left + 1;
    }

    // 快慢指针
    public int removeElement1(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // 快指针找到一个不是目标值的元素，覆盖慢指针所在元素
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode27 leetcode27 = new Leetcode27();
        System.out.println(leetcode27.removeElement(new int[]{3,3,3}, 3));
    }
}
