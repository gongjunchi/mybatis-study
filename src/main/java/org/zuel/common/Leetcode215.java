package org.zuel.common;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Leetcode215 {

    private Random random = new Random(System.currentTimeMillis());

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

    /**
     * 这道题用堆的思路没有问题，还应该注意到我们不需要维护一个包含全部元素的堆
     * 对于找第K大的元素，只需要维护一个K个元素的最小堆，堆顶的元素实际上是整个数组升序排列后靠后的K个元素的第一个
     * 时间复杂度：O(NlogK)，遍历数据O(N)，堆内元素调整O(logK)
     * 空间复杂度：O(K)
     */
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        // 将前k个元素放入堆中
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        // 对于后面的元素，跟堆顶元素进行比较
        for (int i = k; i < len; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    /**
     * 快排
     * 时间复杂度：o(N)
     * 空间复杂度：o(1)
     */
    public int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int l = 0, r = len - 1;
        while (true) {
            int index = partition(nums, l, r);
            if (index == target) {
                return nums[index];
            } else if (index > target) {
                r = index - 1;
            } else {
                l = index + 1;
            }
        }
    }

    public int partition(int[] nums, int l, int r) {
        // 如果r大于l，可以计算一个随机数
        if (r > l) {
            int randomIndex = random.nextInt(r - l + 1) + l;
            swap(nums, randomIndex, l);
        }
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
        return i;
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
        System.out.println(leetcode215.findKthLargest3(new int[]{3,2,1,5,6,4}, 2));
    }
}
