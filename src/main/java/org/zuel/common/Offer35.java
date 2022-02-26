package org.zuel.common;

import java.util.HashMap;

public class Offer35 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        // 一轮循环，建立原节点和新节点间的一一对应关系
        while (cur != null) {
            Node temp = new Node(cur.val);
            map.put(cur, temp);
            cur = cur.next;
        }
        cur = head;
        // 二轮循环，为新节点赋值next和random的具体内容
        while (cur != null) {
            // 注意这个地方不是cur.next，因为cur.next是原链表的元素，而不是新链表
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
