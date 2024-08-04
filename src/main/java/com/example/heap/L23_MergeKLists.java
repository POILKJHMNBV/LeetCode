package com.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L23_MergeKLists {
    public static void main(String[] args) {
        ListNode list1 = getList(new int[]{1, 4, 5});
        ListNode list2 = getList(new int[]{1, 3, 4});
        ListNode list3 = getList(new int[]{2, 6});
        ListNode result = mergeKLists(new ListNode[]{list1, list2, list3});
        printList(result);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            while (listNode != null) {
                priorityQueue.offer(listNode);
                listNode = listNode.next;
            }
        }
        int size = priorityQueue.size();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            if (!priorityQueue.isEmpty()) {
                nums[i] = priorityQueue.poll().val;
            }
        }
        return getList(nums);
    }

    private static ListNode getList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode curNode = head;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            curNode.next = new ListNode(nums[i]);
            curNode = curNode.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val).append(", ");
            head = head.next;
        }
        int length = sb.length();
        if (length != 1) {
            sb.deleteCharAt(length - 1);
            sb.deleteCharAt(length - 2);
        }
        sb.append("]");
        System.out.println(sb);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
