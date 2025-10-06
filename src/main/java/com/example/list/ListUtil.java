package com.example.list;

public class ListUtil {
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        while (head != null) {
            stringBuilder.append(head.val).append(",");
            head = head.next;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static ListNode buildSingleList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode dummyNode = new ListNode(),  cur = dummyNode;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummyNode.next;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            head.next = nextNode.next;
            nextNode.next = dummyNode.next;
            dummyNode.next = nextNode;
            nextNode = head.next;
        }
        return dummyNode.next;
    }
}
