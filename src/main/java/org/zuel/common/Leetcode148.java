package org.zuel.common;

public class Leetcode148 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = getMid(head);
        if (mid.next == null) {
            // 中间节点就是自己，不用再分了，直接返回
            return mid;
        }
        // 获取两个链表的头节点，分别是head和mid.next，即headB
        ListNode headB = mid.next;
        // 从中间节点处断开，否则就不是两个链表
        mid.next = null;
        return mergeTwoList(sortList(head), sortList(headB));
    }

    // 获取链表的中点，基本操作
    public ListNode getMid(ListNode head) {
        // 做一个虚节点，这样当节点数量为双数时，中点处于中间左侧
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个链表的基本操作
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        // 做一个虚节点，最终返回的是dummy.next
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int p1 = l, p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            temp[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= r) {
            temp[i++] = nums[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            nums[l + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        Leetcode148 leetcode148 = new Leetcode148();
        int[] nums = new int[]{4,2,5,3,3,1,4,2,7,8,1,9};
        leetcode148.mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
