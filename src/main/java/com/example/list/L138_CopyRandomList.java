package com.example.list;

/**
 * <p>L138:随机链表的复制</p>
 */
public class L138_CopyRandomList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;
        Node head = copyRandomList(node1);
        System.out.println(123);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 开始复制节点
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }

        // 开始复制链表
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // 断开旧链表和新链表的连接
        cur = head;
        Node newHead = cur.next;
        Node nextNode = newHead;
        while (cur != null) {
            cur.next = nextNode.next;
            cur = cur.next;
            nextNode.next = cur == null ? null : cur.next;
            nextNode = nextNode.next == null ? null : nextNode.next;
        }
        return newHead;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}