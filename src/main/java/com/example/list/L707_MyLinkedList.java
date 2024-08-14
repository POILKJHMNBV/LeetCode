package com.example.list;

/**
 * L707:设计链表
 * @author zhenwu
 * @date 2024/8/14 20:51
 */
public class L707_MyLinkedList {

}

class MyLinkedList {

    private transient int size;

    private Node first, last;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return node(index).item;
    }

    public void addAtHead(int val) {
        linkedFirst(val);
    }

    public void addAtTail(int val) {
        likedLast(val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            likedLast(val);
            return;
        }
        linkedBefore(val, node(index));
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        unlink(node(index));
    }

    Node node(int index) {
        Node x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    void unlink(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        size--;
    }

    void linkedFirst(int val) {
        final Node f = first;
        final Node newNode = new Node(val, f, null);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    void likedLast(int val) {
        final Node l = last;
        final Node newNode = new Node(val, null, l);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    void linkedBefore(int val, Node successiveNode) {
        final Node prev = successiveNode.prev;
        final Node newNode = new Node(val, successiveNode, prev);
        successiveNode.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    private static class Node {
        int item;
        Node next;
        Node prev;

        public Node(int item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
