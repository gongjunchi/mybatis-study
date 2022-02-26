package org.zuel.common;

public class Offer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        if (h1 == null || h2 == null) {
            return null;
        }
        while (h1 != h2) {
//            if (h1 == null && h2 == null) {
//                break;
//            }
            if (h1 == null) {
                h1 = headB;
            } else {
                h1 = h1.next;
            }
            if (h2 == null) {
                h2 = headA;
            } else {
                h2 = h2.next;
            }
        }
        return h1;
    }


    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node12 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node42 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node52 = new ListNode(5);
        ListNode node0 = new ListNode(0);
        ListNode headA = node4;
        node4.next = node1;
        node1.next = node8;
        node8.next = node42;
        node42.next = node5;
        ListNode headB = node52;
        node52.next = node0;
        node0.next = node12;
        node12.next = node8;
        Offer52 offer52 = new Offer52();
        System.out.println(offer52.getIntersectionNode(headA, headB).val);
    }
}
