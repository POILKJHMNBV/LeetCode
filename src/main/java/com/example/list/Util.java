package com.example.list;

public class Util {
    public static void printList(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder("[");
        while (head != null) {
            stringBuilder.append(head.val).append(",");
            head = head.next;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
