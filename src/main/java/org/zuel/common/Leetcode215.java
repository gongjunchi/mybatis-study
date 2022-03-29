package org.zuel.common;

import java.util.Comparator;
import java.util.PriorityQueue;

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

    // 用已实现的数据结构
    public int findKthLargest1(int[] nums, int k) {
        // 用优先队列实现一个最大堆，PriorityQueue默认是一个最小堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }
        int res = 0;
        k--;
        while (!maxHeap.isEmpty()) {
            if (k == 0) {
                res =  maxHeap.poll();
                break;
            } else {
                maxHeap.poll();
                k--;
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
        System.out.println(leetcode215.findKthLargest1(new int[]{3,2,1,5,6,4}, 2));
    }
}
