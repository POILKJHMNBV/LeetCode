package com.example.list;

class SingleList {
    private int size = 0;
    ListNode head;
    ListNode last;

    public boolean add(int value) {
        ListNode node = last;
        ListNode listNode = new ListNode(value, null);
        last = listNode;
        if (node == null) {
            head = listNode;
        } else {

        }
        size++;
        return true;
    }
}
