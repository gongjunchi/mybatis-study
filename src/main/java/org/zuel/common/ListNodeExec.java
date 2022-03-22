package org.zuel.common;

/**
 * 链表相关的基本操作
 */
public class ListNodeExec {

    // 找链表的中点
    public ListNode getMid(ListNode head) {
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

    // 按大小合并两个链表
    public ListNode mergeList(ListNode l1, ListNode l2) {
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
        // 注意这里是if语句，否则会死循环
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }

    // 反转链表
    public ListNode reverse(ListNode head) {
        // 不能新加节点
        // ListNode dummy = new ListNode();
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            // 不能写这一句，否则会成环 next.next = cur;
            // pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNodeExec exec = new ListNodeExec();
        ListNode headA = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode headB = new ListNode(3);
        ListNode node4 = new ListNode(4);
        headA.next = node2;
        node2.next = node3;
        headB.next = node4;
        // ListNode res = exec.mergeList(headA, headB);
        ListNode res = exec.reverse(headA);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
