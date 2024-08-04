package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N48_DeleteNode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        SingleList list = new SingleList(nums[1]);
        for (int i = 2; i < nums.length - 2; i += 2) {
            list.insert(nums[i], nums[i + 1]);
        }
        list.delete(nums[nums.length - 1]);
        System.out.println(list);
    }
}
class Node {
    final int item;
    Node next;
    public Node(int item) {
        this.item = item;
    }
}

class SingleList {
    Node root;

    public SingleList(int root) {
        this.root = new Node(-1);
        this.root.next = new Node(root);
    }

    public void insert(int a, int b) {
        Node cur = this.root.next;
        while (cur != null && cur.item != b) {
            cur = cur.next;
        }
        Node node = new Node(a);
        node.next = cur.next;
        cur.next = node;
    }

    public void add(int a) {
        Node cur = this.root.next;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(a);
    }

    public void delete(int item) {
        Node cur = root;
        while (cur.next != null) {
            if (cur.next.item == item) {
                cur.next = cur.next.next;
            }
            if (cur.next != null && cur.next.item != item) {
                cur = cur.next;
            }
        }
    }

    public int delIndex(int index) {
        Node cur = this.root;
        int count = 0;
        while (cur != null && count != index) {
            cur = cur.next;
            count++;
        }
        int res = cur.next.item;
        cur.next = cur.next.next;
        return res;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = this.root.next;
        while (cur != null) {
            sb.append(cur.item).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }
}