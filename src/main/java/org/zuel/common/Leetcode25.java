package org.zuel.common;

import java.util.Stack;

public class Leetcode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 做一个虚拟头节点，最终返回的时候用
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // K个节点为一组的反转，为了反转后链表仍然能串起来，也需要记录几个指针，pre是整个需要反转的子链表的前一个节点，next是需要反转的子链表的后继节点
        // 对于需要反转的部分，需要它的start和end，并且end的后一个节点需要设置为null，即子链表要有边界
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                // 如果end为空，说明链表长度没有k大，直接把原链表返回
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            // 因为之前设置了end.next = null，链表断了，现在需要将链表重新连起来，反转后的子链表尾是start
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    // 应该看到，反转这个过程会被反复调用，因此可以单独做一个方法
    public ListNode reverse(ListNode head) {
        // 反转链表需要3个指针，分别记录当前节点、前一个节点、后继节点才能完成反转操作
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 最终pre是头节点
        return pre;
    }
}
