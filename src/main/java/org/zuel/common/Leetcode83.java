package org.zuel.common;

public class Leetcode83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (pre != null && cur.val == pre.val) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return head;
    }
}
