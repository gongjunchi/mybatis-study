package org.zuel.common;

import java.util.HashSet;

public class Leetcode82 {

    public ListNode deleteDuplicates(ListNode head) {
        // 递归终止条件，当节点已经是null或者只有头节点一个时
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            // 如果头节点值和后继节点值不相同，头节点要保留，头节点的后继节点是以头节点的后继节点作为头节点的递归返回值
            head.next = deleteDuplicates(head.next);
        } else {
            // 如果头节点值和后继节点值相同，头节点不要了，移动到值不同的第一个节点，从那里开始递归
            ListNode move = head;
            while (move != null && move.val == head.val) {
                move = move.next;
            }
            return deleteDuplicates(move);
        }
        return head;
    }
}
